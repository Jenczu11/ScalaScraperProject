package Parser

import Downloader.{BaseDownloader, DownloaderFactory, DownloaderType}
import org.scalatest.funsuite.AnyFunSuite

class CharactersSearchParserTest extends AnyFunSuite {
  val charactersSearchDownloader: BaseDownloader = DownloaderFactory(DownloaderType.CharactersSearch)

  test("Search characters with 'jack'") {
    val elements = charactersSearchDownloader.download("jack")
    val charactersSearchParser = new CharactersSearchParser(elements)
    val resultsList = charactersSearchParser.parseToResultList()
    assert(resultsList.size == 9)
  }

  test("Search characters with 'batman'") {
    val elements = charactersSearchDownloader.download("batman")
    val charactersSearchParser = new CharactersSearchParser(elements)
    val resultsList = charactersSearchParser.parseToResultList()
    assert(resultsList.size == 1)
  }
}
