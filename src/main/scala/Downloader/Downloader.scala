package Downloader

import Configuration.DownloaderConfiguration
import net.ruippeixotog.scalascraper.model.Element

trait Downloader extends DownloaderConfiguration{
  def download(query: String): List[Element]
}
