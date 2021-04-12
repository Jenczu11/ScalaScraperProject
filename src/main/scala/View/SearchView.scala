package View

import Model.SearchResult.BaseSearchResult
import View.ObjectType.ObjectType

class SearchView(searchType: ObjectType) extends ViewBase() with View {

  def display(): Unit = {
    println(delimiter)
    searchType match {
      case ObjectType.Movies => println("Wyszukiwanie filmów")
      case ObjectType.Persons => println("Wyszukiwanie ludzi kina")
      case ObjectType.Characters => println("Wyszukiwanie postaci")
    }
    println(
      "Wpisz wyszukiwaną frazę: "
    )
  }

  def displaySearchResults(results: List[BaseSearchResult]): Unit = {
    var output: String = delimiter + System.lineSeparator
    if (results.isEmpty) {
      output += "Nie znaleziono wyników!"
      println(output)
      return
    }
    output += "Znaleziono " + results.size + " wyników: " + System.lineSeparator
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
      output += "Wybierz liczbę od 1 do " + resultsSize + " aby zobaczyć szczegóły "
      searchType match {
        case ObjectType.Movies => output += "filmu."
        case ObjectType.Persons => output += "osoby."
        case ObjectType.Characters => output += "postaci."
      }
      output += System.lineSeparator
    }
    output += "Wybierz 0 aby wyszukać ponownie lub -1 aby wyjść do menu głównego."
    println(output)
  }
}
