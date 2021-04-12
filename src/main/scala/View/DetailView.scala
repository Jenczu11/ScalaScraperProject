package View

import Model.SearchResult.BaseSearchResult
import View.ObjectType.ObjectType

class DetailView(objectType: ObjectType) extends ViewBase {
  def display(): Unit = {
    objectType match {
      case ObjectType.Movies => println("Szczegóły filmu")
      case ObjectType.Persons => println("Szczegóły osoby")
      case ObjectType.Characters => println("Szczegóły postaci")
    }
  }

  def displayDetails(detailedObject: Any): Unit = {
    println(delimiter + System.lineSeparator + detailedObject)
  }
}
