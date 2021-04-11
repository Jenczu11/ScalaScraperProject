package Parser.Details

import Downloader.{Downloader, DownloaderFactory, DownloaderType}
import org.scalatest.funsuite.AnyFunSuite

class MovieDetailsParserTest extends AnyFunSuite {
  val detailsDownloader: Downloader = DownloaderFactory(DownloaderType.Details)

  test("Get details of movie 'Forrest Gump'") {
    val elements = detailsDownloader.download("/film/Forrest+Gump-1994-998")
    val movieDetailsParser = new MovieDetailsParser(elements)
    val movie = movieDetailsParser.parseItemsToObject()
    println(movie)
    assert(movie.genre.equals("Dramat / Komedia"))
    assert(movie.director.equals("Robert Zemeckis"))
    assert(movie.title.equals("Forrest Gump"))
  }

  test("Get details of movie '300'") {
    val elements = detailsDownloader.download("/film/300-2006-163597")
    val movieDetailsParser = new MovieDetailsParser(elements)
    val movie = movieDetailsParser.parseItemsToObject()
    println(movie)
    assert(movie.genre.equals("Dramat historyczny"))
    assert(movie.director.equals("Zack Snyder"))
    assert(movie.title.equals("300"))
  }
}
