import Downloader.{DownloaderFactory, DownloaderType}
import Parser.BaseParser
import Parser.Search.CharactersSearchParser
import net.ruippeixotog.scalascraper.dsl.DSL.deepFunctorOps
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._


object Main extends App {
//  val detailsDownloader = DownloaderFactory(DownloaderType.Details)
//  val elements = detailsDownloader.download("/person/Jack+O'Connell-651840")

  val charactersSearchDownloader = DownloaderFactory(DownloaderType.CharactersSearch)
  val elements = charactersSearchDownloader.download("jack")
  val charactersSearchParser = new CharactersSearchParser(elements)
  println(charactersSearchParser.parseItems())
}
