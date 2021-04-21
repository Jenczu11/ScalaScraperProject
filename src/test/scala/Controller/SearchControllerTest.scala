package Controller

import Downloader.DownloaderType
import View.ObjectType
import org.scalatest.flatspec.AnyFlatSpec

class SearchControllerTest extends AnyFlatSpec {

  behavior of "SearchControllerTest"

  val controllerM = new SearchController(DownloaderType.MoviesSearch)
  "Search controller for movies" should "have objectType: Movies" in {
    assert(controllerM.objectType.equals(ObjectType.Movies))
  }

  it should "have downloaderType: MoviesSearch" in {
    assert(controllerM.downloaderType.equals(DownloaderType.MoviesSearch))
  }

  val controllerP = new SearchController(DownloaderType.PersonsSearch)
  "Search controller for persons" should "have objectType: Persons" in {
    assert(controllerP.objectType.equals(ObjectType.Persons))
  }

  it should "have downloaderType: PersonsSearch" in {
    assert(controllerP.downloaderType.equals(DownloaderType.PersonsSearch))
  }

  val controllerC = new SearchController(DownloaderType.CharactersSearch)
  "Search controller for characters" should "have objectType: Characters" in {
    assert(controllerC.objectType.equals(ObjectType.Characters))
  }

  it should "have downloaderType: CharactersSearch" in {
    assert(controllerC.downloaderType.equals(DownloaderType.CharactersSearch))
  }

}
