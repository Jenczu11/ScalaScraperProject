package Downloader

import net.ruippeixotog.scalascraper.scraper.ContentExtractors.elementList
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.model.Element

class PersonsDownloader extends BaseDownloader {
  override val baseUrl: String = "https://www.filmweb.pl/persons/search?q="

  override def download(query: String): List[Element] = {
    val browser = JsoupBrowser()
    val doc = browser.get(baseUrl + query)
    doc >> elementList("#searchResult > li")
  }
}