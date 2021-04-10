package Parser

import Downloader.{Downloader, DownloaderFactory, DownloaderType}
import View.ViewHelper
import org.scalatest.funsuite.AnyFunSuite

class PersonsSearchParserTest extends AnyFunSuite {
  val personsSearchDownloader: Downloader = DownloaderFactory(DownloaderType.PersonsSearch)

  test("Search persons with 'di caprio'") {
    val elements = personsSearchDownloader.download("di caprio")
    val personsSearchParser = new PersonsSearchParser(elements)
    val resultsList = personsSearchParser.parseItems()
    print(ViewHelper.printSearchResults(resultsList))
    assert(resultsList.size == 8)
  }

  test("Search persons with 'tom hanks'") {
    val elements = personsSearchDownloader.download("Viola di caprio")
    val personsSearchParser = new PersonsSearchParser(elements)
    val resultsList = personsSearchParser.parseItems()
    print(ViewHelper.printSearchResults(resultsList))
    assert(resultsList.size == 1)
  }
}
