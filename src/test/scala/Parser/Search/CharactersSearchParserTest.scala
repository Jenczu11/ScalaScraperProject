package Parser.Search

import Downloader.{Downloader, DownloaderFactory, DownloaderType}
import View.{SearchType, SearchView}
import org.scalatest.funsuite.AnyFunSuite

class CharactersSearchParserTest extends AnyFunSuite {
  val charactersSearchDownloader: Downloader = DownloaderFactory(DownloaderType.CharactersSearch)

  test("Search characters with 'jack'") {
    val elements = charactersSearchDownloader.download("jack")
    val charactersSearchParser = new CharactersSearchParser(elements)
    val resultsList = charactersSearchParser.parseItemsToList()
    val searchView = new SearchView(SearchType.Characters)
    print(searchView.displaySearchResults(resultsList))
    assert(resultsList.size == 9)
  }

  test("Search characters with 'batman'") {
    val elements = charactersSearchDownloader.download("batman")
    val charactersSearchParser = new CharactersSearchParser(elements)
    val resultsList = charactersSearchParser.parseItemsToList()
    val searchView = new SearchView(SearchType.Characters)
    print(searchView.displaySearchResults(resultsList))
    assert(resultsList.size == 1)
  }
}
