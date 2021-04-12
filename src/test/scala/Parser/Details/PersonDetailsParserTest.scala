package Parser.Details

import Downloader.{Downloader, DownloaderFactory, DownloaderType}
import Model.PersonType
import org.scalatest.funsuite.AnyFunSuite

class PersonDetailsParserTest extends AnyFunSuite {
  val detailsDownloader: Downloader = DownloaderFactory(DownloaderType.Details)

  test("Get details of person 'Tom Hanks'") {
    val elements = detailsDownloader.download("/person/Tom+Hanks-124")
    val personDetailsParser = new PersonDetailsParser(elements)
    val person = personDetailsParser.parseItemsToObject()
    println(person)
    assert(person.name.equals("Tom Hanks"))
    assert(person.placeOfBirth.equals("Concord, Kalifornia, USA"))
    assert(person.personType.head.equals(PersonType.Actor))
  }

  test("Get details of person 'Clint Eastwood'") {
    val elements = detailsDownloader.download("/person/Clint+Eastwood-122")
    val personDetailsParser = new PersonDetailsParser(elements)
    val person = personDetailsParser.parseItemsToObject()
    println(person)
    assert(person.name.equals("Clint Eastwood"))
    assert(person.placeOfBirth.equals("San Francisco, Kalifornia, USA"))
    assert(person.personType.size.equals(2))
  }

}
