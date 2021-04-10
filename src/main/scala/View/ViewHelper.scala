package View

import Model.SearchResult.BaseSearchResult

object ViewHelper {
  def printSearchResults(results: List[BaseSearchResult]): String = {
    var output: String = "Znaleziono " + results.size + " wyników: " + System.lineSeparator
    var position: Int = 1
    for (result <- results) {
      output += position + ". " + result + System.lineSeparator
      position += 1
    }
    output
  }

}
