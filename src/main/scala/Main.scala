import Downloader.{DownloaderFactory, DownloaderType}

object Main extends App {
  val moviesDownloader = DownloaderFactory(DownloaderType.Movies)
  val results = moviesDownloader.download("wonder%20woman")
  println(results)
}
