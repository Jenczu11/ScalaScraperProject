package Downloader

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.model.Element
import net.ruippeixotog.scalascraper.scraper.ContentExtractors.elementList

class DetailsDownloader extends Downloader {
  override def download(query: String): List[Element] = {
    val browser = JsoupBrowser()
    val doc = browser.get(baseUrl + query)
    val g1 = doc >> elementList("[data-group=\"g1\"]")
    val g2 = doc >> elementList("[data-group=\"g2\"]")
    g1 ++ g2
  }
}
