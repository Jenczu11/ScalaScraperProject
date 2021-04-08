package Downloader.Search

import Downloader.BaseDownloader
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.model.Element
import net.ruippeixotog.scalascraper.scraper.ContentExtractors.elementList

class BaseSearchDownloader extends BaseDownloader {
  override def download(query: String): List[Element] = {
    val browser = JsoupBrowser()
    val doc = browser.get(baseUrl + query)
    doc >> elementList("#searchResult > li")
  }
}
