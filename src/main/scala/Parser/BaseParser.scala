package Parser

import net.ruippeixotog.scalascraper.model.Element
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._

import scala.collection.mutable.ListBuffer

class BaseParser(items: List[Element]) {
  def getItemText(itemPropName: String): List[Option[String]] = {
    val query: String = "[itemprop=\"" + itemPropName + "\"]"
    items.map(_ >?> text(query))
  }

  def getClassText(className: String): List[Option[String]] = {
    val query: String = "." + className
    items.map(_ >?> text(query))
  }

  def getLinkInClass(className: String): List[Option[String]] = {
    val query: String = "." + className + " a"
    items.map(_ >?> attr("href")(query))
  }

  def optionsListToList(values: List[Option[String]]): List[String] = {
    var listBuffer = new ListBuffer[String]()
    for (value <- values) {
      value match {
        case Some(value) => listBuffer += value
        case None => // Do nothing.
      }
    }
    listBuffer.toList
  }
}
