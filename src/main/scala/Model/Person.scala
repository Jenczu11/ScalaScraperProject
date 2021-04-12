package Model

import Model.PersonType.PersonType

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class Person {
  val personType: List[PersonType] = List.empty[PersonType]
  val name: String = "name"
  val description: String = "description"
  val dateOfBirth: String = "2000-01-01"
  val placeOfBirth: String = "place"
  val height: String = "0"

  def this(fields: mutable.Map[String, Any]) {
    this()
    for ((name, value) <- fields) {
      ModelHelper.setField(this, name, value)
    }
  }

  override def toString: String = {
    var personTypeBuffer = ListBuffer[String]()
    for (pt <- personType) {
      personTypeBuffer += pt.toString
    }

    s"Imię i nazwsko: $name" + System.lineSeparator +
    s"Zawód filmowy: ${personTypeBuffer.toList.mkString(", ")}" + System.lineSeparator +
    s"Data urodzenia: $dateOfBirth" + System.lineSeparator +
    s"Miejsce urodzenia: $placeOfBirth" + System.lineSeparator +
    s"Wzrost: $height" + System.lineSeparator +
    s"Opis: $description" + System.lineSeparator
  }
}
