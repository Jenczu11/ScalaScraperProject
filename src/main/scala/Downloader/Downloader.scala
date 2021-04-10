package Downloader

import net.ruippeixotog.scalascraper.model.Element

trait Downloader {
  val baseUrl: String = "https://www.filmweb.pl"
  def download(query: String): List[Element]
}
