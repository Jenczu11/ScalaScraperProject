package Parser.Details

import Downloader.{Downloader, DownloaderFactory, DownloaderType}
import Model.PersonType
import org.scalatest.funsuite.AnyFunSuite

class CharacterDetailsParserTest extends AnyFunSuite {
  val detailsDownloader: Downloader = DownloaderFactory(DownloaderType.Details)

  test("Get details of person 'Tom Hanks'") {
    val elements = detailsDownloader.download("/character/Forrest+Gump-487")
    val characterDetailsParser = new CharacterDetailsParser(elements)
    val character = characterDetailsParser.parseItemsToObject()
    println(character)
    assert(character.name.equals("Forrest Gump"))
    assert(character.dateOfCreation.equals("1986"))
    assert(character.country.equals("USA"))
  }

}
