package View

import Model.SearchResult.BaseSearchResult
import View.ObjectType.ObjectType
import com.osinka.i18n.Messages

class DetailView(objectType: ObjectType) extends ViewBase {
  def display(): Unit = {
    objectType match {
      case ObjectType.Movies => println(Messages("detailview.movies"))
      case ObjectType.Persons => println(Messages("detailview.persons"))
      case ObjectType.Characters => println(Messages("detailview.characters"))
    }
  }

  def displayDetails(detailedObject: Any): Unit = {
    println(delimiter + System.lineSeparator + detailedObject)
  }
}
