package Downloader

import Downloader.DownloaderType.DownloaderType
import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec

class DownloaderFactoryTest extends AnyFeatureSpec with GivenWhenThen {

  Feature("Creating search downloader") {
    Scenario("User wants to find information about a movie") {

      Given("Movie downloader")
      val downloaderType : DownloaderType = DownloaderType.MoviesSearch
      val downloader = DownloaderFactory.apply(downloaderType)
      assert(downloader.baseUrl.contains("films"))

      When("User chose to search for a movie details")
      Then("The downloader url should contain a word 'films'")
      info("Downloader url: " + downloader.baseUrl)
    }

    Scenario("User wants to find information about a person") {

      Given("Person downloader")
      val downloaderType : DownloaderType = DownloaderType.PersonsSearch
      val downloader = DownloaderFactory.apply(downloaderType)
      assert(downloader.baseUrl.contains("persons"))

      When("User chose to search for a person details")
      Then("The downloader url should contain a word 'persons'")
      info("Downloader url: " + downloader.baseUrl)
    }

    Scenario("User wants to find information about a character") {

      Given("Character downloader")
      val downloaderType : DownloaderType = DownloaderType.CharactersSearch
      val downloader = DownloaderFactory.apply(downloaderType)
      assert(downloader.baseUrl.contains("characters"))

      When("User chose to search for a character details")
      Then("The downloader url should contain a word 'characters'")
      info("Downloader url: " + downloader.baseUrl)
    }
  }
}
