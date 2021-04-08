package Downloader

import net.ruippeixotog.scalascraper.model.Element

trait BaseDownloader {
  val baseUrl: String = "https://www.filmweb.pl"
  def download(query: String): List[Element]
}
