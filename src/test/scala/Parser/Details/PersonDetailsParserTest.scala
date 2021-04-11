package Parser.Details

import Downloader.{Downloader, DownloaderFactory, DownloaderType}
import org.scalatest.funsuite.AnyFunSuite

class PersonDetailsParserTest extends AnyFunSuite {
  val detailsDownloader: Downloader = DownloaderFactory(DownloaderType.Details)

  test("Get details of person Tom Hanks") {
    val elements = detailsDownloader.download("/person/Tom+Hanks-124")
    val personDetailsParser = new PersonDetailsParser(elements)
    val person = personDetailsParser.parseItemsToObject()
    assert(person.name.equals("Tom Hanks"))
    assert(person.placeOfBirth.equals("Concord, Kalifornia, USA"))
  }

}
