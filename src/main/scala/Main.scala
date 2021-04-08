import Downloader.{DownloaderFactory, DownloaderType}

object Main extends App {
//  val moviesDownloader = DownloaderFactory(DownloaderType.MoviesSearch)
//  val results = moviesDownloader.download("wonder%20woman")
//  println(results)

  val detailsDownloader = DownloaderFactory(DownloaderType.Details)
  val details = detailsDownloader.download("/person/Tom+Hanks-124")
  println(details)
}
