package Model

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
    s"Postać: $name" + System.lineSeparator +
    s"Liczba polubień: $numberOfLikes" + System.lineSeparator +
    s"Twórca: $creator" + System.lineSeparator +
    s"Data powstania: $dateOfCreation" + System.lineSeparator +
    s"Pochodzenie: $country" + System.lineSeparator +
    s"Opis: $description" + System.lineSeparator
}
