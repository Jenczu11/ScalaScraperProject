import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._

object Main extends App {
  println("Hello")
  val browser = JsoupBrowser()
  val doc = browser.get("https://www.filmweb.pl/films/search?q=wonder%20woman")
  val searchResult = doc >> elementList("#searchResult > li")
  searchResult.foreach(res => {
    val title = res >?> text(".filmPreview__titleDetails")
    println(title)
  })


}
