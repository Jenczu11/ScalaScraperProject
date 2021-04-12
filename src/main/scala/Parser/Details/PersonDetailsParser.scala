package Parser.Details

import Model.PersonType.PersonType
import Model.{Movie, Person, PersonType}
import Parser.BaseParser
import net.ruippeixotog.scalascraper.model.Element

import scala.collection.mutable
import io.circe._
import io.circe.parser._

import scala.collection.mutable.ListBuffer

class PersonDetailsParser (override val items: List[Element])
  extends BaseParser(items) with DetailsParser [Person] {

  override def parseItemsToObject(): Person = {
    val personFields = parseMainPersonFields()
    personFields += ("personType" -> parsePersonTypes())

    new Person(personFields)
  }

  private def parseMainPersonFields(): mutable.Map[String, Any] = {
    val personFieldsMapOptions = mutable.Map[String, List[Option[String]]](
      "name" -> getItemPropText("url"),
      "description" -> getItemPropText("description"),
      "dateOfBirth" -> getItemPropText("birthDate"),
      "placeOfBirth" -> getItemPropText("birthPlace"),
      "height" -> getItemPropText("height")
    )
    optionsMapToAnyMap(personFieldsMapOptions)
  }

  private def parsePersonTypes(): List[PersonType] = {
    val dataSource = getClassText("dataSource")
    val dataJson = optionsListToFirstElement(dataSource)
    val personTypesBuffer = ListBuffer[PersonType]()

    parse(dataJson) match {
      case Right(result) =>
        for (items <- result.asArray) {
          for (personTypeJson <- items) {
            val isPersonType: Boolean =
              personTypeJson.findAllByKey("above5p").head.toString.toBoolean

            if (isPersonType) {
              val career = personTypeJson.findAllByKey("career").head
              val personTypeOption = career.findAllByKey("name").head.as[String]
              personTypeOption match {
                case Right(personType) =>
                  personTypesBuffer += PersonType.mapFromString(personType)
              }
            }
          }
        }
    }
    personTypesBuffer.toList
  }
}