package Downloader

import Downloader.DownloaderType.DownloaderType

object DownloaderFactory {
  def apply(downloaderType: DownloaderType): BaseDownloader = downloaderType match {
    case DownloaderType.Movies => new MoviesDownloader()
    case DownloaderType.Persons => new PersonsDownloader()
    case DownloaderType.Characters => new CharactersDownloader()
  }
}
