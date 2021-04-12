package Parser.Search

import Downloader.{Downloader, DownloaderFactory, DownloaderType}
import View.{SearchType, SearchView}
import org.scalatest.funsuite.AnyFunSuite

class MoviesSearchParserTest extends AnyFunSuite {
  val moviesSearchDownloader: Downloader = DownloaderFactory(DownloaderType.MoviesSearch)

  test("Search movies with '300'") {
    val elements = moviesSearchDownloader.download("300")
    val moviesSearchParser = new MoviesSearchParser(elements)
    val resultsList = moviesSearchParser.parseItemsToList()
    val searchView = new SearchView(SearchType.Movies)
    print(searchView.displaySearchResults(resultsList))
    assert(resultsList.size == 10)
  }

  test("Search movies with 'Gump'") {
    val elements = moviesSearchDownloader.download("Gump")
    val moviesSearchParser = new MoviesSearchParser(elements)
    val resultsList = moviesSearchParser.parseItemsToList()
    val searchView = new SearchView(SearchType.Movies)
    print(searchView.displaySearchResults(resultsList))
    assert(resultsList.size == 6)
  }
}
