package Controller
import Downloader.DownloaderType.{CharactersSearch, DownloaderType, MoviesSearch, PersonsSearch}
import Model.SearchResult.BaseSearchResult
import View.ObjectType.{Characters, Movies, ObjectType, Persons}
import org.scalatest.GivenWhenThen
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.propspec.AnyPropSpec


class DetailsControllerTest extends AnyPropSpec with TableDrivenPropertyChecks with GivenWhenThen {

  private val values = Table(("DownloaderT", "ObjectT"), (MoviesSearch, Movies), (PersonsSearch, Persons), (CharactersSearch, Characters))

  property("objectType property") {
    forAll(values) { (DownloaderT: DownloaderType, ObjectT: ObjectType) =>
      val controller = new DetailsController(new BaseSearchResult("none", "none"), ObjectT, DownloaderT)
      Given("Downloader type: " + DownloaderT)
      When("Details controller is created")
      Then("Object type inside controller should be: " + ObjectT)
      assert(controller.objectType === ObjectT)
    }
  }

}
