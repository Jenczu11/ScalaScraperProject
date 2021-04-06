import net.ruippeixotog.scalascraper.browser.JsoupBrowser

object Main extends App {
  println("Hello")
  val browser = JsoupBrowser()
//  val doc = browser.parseFile("src/test/resources/example.html")
  val doc2 = browser.get("http://example.com")
  println(doc2)
}
