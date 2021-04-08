package Downloader

import Downloader.DownloaderType.DownloaderType
import Downloader.Search.{CharactersSearchDownloader, MoviesSearchDownloader, PersonsSearchDownloader}

object DownloaderFactory {
  def apply(downloaderType: DownloaderType): BaseDownloader = downloaderType match {
    case DownloaderType.MoviesSearch => new MoviesSearchDownloader()
    case DownloaderType.PersonsSearch => new PersonsSearchDownloader()
    case DownloaderType.CharactersSearch => new CharactersSearchDownloader()
  }
}
