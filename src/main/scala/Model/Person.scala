package Model

import Configuration.AppLanguage.userLang
import Model.PersonType.PersonType
import com.osinka.i18n.Messages

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

  override def toString: String = {

//    TODO: Po co jest to jak można dać mkString na personType?
//    var personTypeBuffer = ListBuffer[String]()
//    for (pt <- personType) {
//      personTypeBuffer += pt.toString
//    }

      Messages("person.name",name) + System.lineSeparator +
      Messages("person.persontype",personType.mkString(", ")) + System.lineSeparator +
      Messages("person.dateofbirth", dateOfBirth) + System.lineSeparator +
      Messages("person.placeofbirth", placeOfBirth) + System.lineSeparator +
      Messages("person.height", height) + System.lineSeparator +
//      Messages("person.description", description.split("(?<=\\.)").mkString(System.lineSeparator())) + System.lineSeparator
      Messages("person.description", description) + System.lineSeparator
  }
}
