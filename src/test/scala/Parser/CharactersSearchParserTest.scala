package Parser

import Downloader.{Downloader, DownloaderFactory, DownloaderType}
import View.ViewHelper
import org.scalatest.funsuite.AnyFunSuite

class CharactersSearchParserTest extends AnyFunSuite {
  val charactersSearchDownloader: Downloader = DownloaderFactory(DownloaderType.CharactersSearch)

  test("Search characters with 'jack'") {
    val elements = charactersSearchDownloader.download("jack")
    val charactersSearchParser = new CharactersSearchParser(elements)
    val resultsList = charactersSearchParser.parseItems()
    print(ViewHelper.printSearchResults(resultsList))
    assert(resultsList.size == 9)
  }

  test("Search characters with 'batman'") {
    val elements = charactersSearchDownloader.download("batman")
    val charactersSearchParser = new CharactersSearchParser(elements)
    val resultsList = charactersSearchParser.parseItems()
    print(ViewHelper.printSearchResults(resultsList))
    assert(resultsList.size == 1)
  }
}
