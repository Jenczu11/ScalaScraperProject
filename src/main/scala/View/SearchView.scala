package View

import Configuration.AppLanguage.userLang
import Model.SearchResult.BaseSearchResult
import View.ObjectType.ObjectType
import com.osinka.i18n.Messages

class SearchView(searchType: ObjectType) extends ViewBase() with View {

  def display(): Unit = {
    println(delimiter)
    searchType match {
      case ObjectType.Movies => println(Messages("searchview.movies"))
      case ObjectType.Persons => println(Messages("searchview.persons"))
      case ObjectType.Characters => println(Messages("searchview.characters"))
    }
    println(
      Messages("searchview.searchprompt")
    )
  }

  def displaySearchResults(results: List[BaseSearchResult]): Unit = {
    var output: String = delimiter + System.lineSeparator
    if (results.isEmpty) {
      output += Messages("searchview.noresults")
      println(output)
      return
    }
    output += Messages("searchview.noresults", results.size) + System.lineSeparator
    var position: Int = 1
    for (result <- results) {
      output += position + ". " + result + System.lineSeparator
      position += 1
    }
    println(output)
  }

  def displayOptions(resultsSize: Int): Unit = {
    var output = ""
    if (resultsSize > 0) {
      searchType match {
        case ObjectType.Movies => output += Messages("searchview.displayoptions.movie", resultsSize)
        case ObjectType.Persons => output += Messages("searchview.displayoptions.persons", resultsSize)
        case ObjectType.Characters => output += Messages("searchview.displayoptions.characters", resultsSize)
      }
      output += System.lineSeparator
    }
    output += Messages("searchview.againprompt")
    println(output)
  }
}
