package Model

import Model.PersonType.PersonType

import scala.collection.mutable

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

  override def toString: String = s"Person(" +
    s"$personType, $name, $description, $dateOfBirth, $placeOfBirth, $height)"
}
