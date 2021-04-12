package Parser.Details

import Parser.BaseParser
import net.ruippeixotog.scalascraper.model.Element
import Model.Character

import scala.collection.mutable

class CharacterDetailsParser(override val items: List[Element])
  extends BaseParser(items) with DetailsParser[Character] {

  override def parseItemsToObject(): Character = {
    val characterFieldsOptions = mutable.Map[String, List[Option[String]]](
      "name" -> getItemPropText("name"),
      "description" -> getItemPropText("description"),
      "numberOfLikes" -> getClassText("commonRating__countNumber"),
      "dateOfCreation" -> getItemPropText("birthDate"),
      "creator" -> getTextWithQuery("[href^=\"/person\"]"),
      "country" -> getItemPropText("nationality"),
    )
    val characterFields = optionsMapToAnyMap(characterFieldsOptions)

    new Character(characterFields)
  }
}