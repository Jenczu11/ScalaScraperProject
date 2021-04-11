package Parser

import Downloader.{Downloader, DownloaderFactory, DownloaderType}
import Parser.Search.MoviesSearchParser
import View.ViewHelper
import org.scalatest.funsuite.AnyFunSuite

class MoviesSearchParserTest extends AnyFunSuite {
  val moviesSearchDownloader: Downloader = DownloaderFactory(DownloaderType.MoviesSearch)

  test("Search movies with '300'") {
    val elements = moviesSearchDownloader.download("300")
    val moviesSearchParser = new MoviesSearchParser(elements)
    val resultsList = moviesSearchParser.parseItems()
    print(ViewHelper.printSearchResults(resultsList))
    assert(resultsList.size == 10)
  }

  test("Search movies with 'Gump'") {
    val elements = moviesSearchDownloader.download("Gump")
    val moviesSearchParser = new MoviesSearchParser(elements)
    val resultsList = moviesSearchParser.parseItems()
    print(ViewHelper.printSearchResults(resultsList))
    assert(resultsList.size == 6)
  }
}
