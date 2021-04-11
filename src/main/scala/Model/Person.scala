package Model

import Model.PersonType.PersonType

import scala.collection.mutable

class Person {
  val personType: PersonType = PersonType.Actor
  val name: String = "name"
  //val surname: String = "surname"
  val description: String = "description"
  val age: String = "0"
  val dateOfBirth: String = "2000-01-01"
  val placeOfBirth: String = "place"
  val height: String = "0"

  def this(fields: mutable.Map[String, Any]) {
    this()
    for ((name, value) <- fields) {
      this.setField(name, value)
    }
  }

  private def setField(fieldName: String, fieldValue: Any) {
    this.getClass.getDeclaredFields.find(_.getName == fieldName) match {
      case Some(field) =>
        field.setAccessible(true)
        field.set(this, fieldValue)
      case None =>
        throw new IllegalArgumentException("No field named " + fieldName)
    }
  }

  override def toString = s"Person($personType, $name, $description, $age, $dateOfBirth, $placeOfBirth, $height)"
}
