package Model

import Model.PersonType.PersonType

class Person {
  val personType: PersonType = PersonType.Actor
  val name: String = "name"
  val surname: String = "surname"
  val description: String = "description"
  val age: Int = 0
  val dateOfBirth: String = "2000-01-01"
  val placeOfBirth: String = "place"
  val height: Int = 0
}
