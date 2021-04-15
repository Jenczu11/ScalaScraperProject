package Model

import Configuration.AppLanguage.userLang
import com.osinka.i18n.Messages
import scala.collection.mutable

class Character {
  val name: String = "name"
  val description: String = "description"
  val numberOfLikes: String = "0"
  val dateOfCreation: String = "2000-01-01"
  val creator: String = "creator"
  val country = "country"

  def this(fields: mutable.Map[String, Any]) {
    this()
    for ((name, value) <- fields) {
      ModelHelper.setField(this, name, value)
    }
  }

  override def toString: String =
    Messages("character.name", name) + System.lineSeparator +
      Messages("character.numberOfLikes", numberOfLikes) + System.lineSeparator +
      Messages("character.creator", creator) + System.lineSeparator +
      Messages("character.dateOfCreation", dateOfCreation) + System.lineSeparator +
      Messages("character.country", country) + System.lineSeparator +
      Messages("character.description", description.split("(?<=\\.)").mkString(System.lineSeparator())) + System.lineSeparator
//      Messages("character.description",description) + System.lineSeparator
}
