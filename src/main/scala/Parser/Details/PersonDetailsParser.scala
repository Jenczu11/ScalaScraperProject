package Parser.Details

import Model.{Movie, Person}
import Parser.BaseParser
import net.ruippeixotog.scalascraper.model.Element

import scala.collection.mutable

class PersonDetailsParser (override val items: List[Element])
  extends BaseParser(items) with DetailsParser [Person] {

  override def parseItemsToObject(): Person = {
    val personFieldsMapOptions = mutable.Map[String, List[Option[String]]](
      "name" -> getItemPropText("url"),
      "description" -> getItemPropText("description"),
      "age" -> getClassText("personAge"),
      "dateOfBirth" -> getItemPropText("birthDate"),
      "placeOfBirth" -> getItemPropText("birthPlace"),
      "height" -> getItemPropText("height")
    )
    val personFieldsMap = mutable.Map[String, Any]()
    for (optionField <- personFieldsMapOptions) {
      personFieldsMap += (optionField._1 -> optionsListToFirstElement(optionField._2))
    }
    println(personFieldsMap)
    val person = new Person(personFieldsMap)
    println(person)
    person
  }
}