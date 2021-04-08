import Downloader.{DownloaderFactory, DownloaderType}
import Parser.ParserHelper
import net.ruippeixotog.scalascraper.dsl.DSL.deepFunctorOps
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._


object Main extends App {
  val detailsDownloader = DownloaderFactory(DownloaderType.Details)
  val elements = detailsDownloader.download("/person/Jack+O'Connell-651840")
  val parserHelper = new ParserHelper()
  println(parserHelper.getItemProp(elements, "name"))

//  val results = elements >> text(".characterPreview__title")
//  println(results)
}
