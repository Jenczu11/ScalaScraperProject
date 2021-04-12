package Parser

import net.ruippeixotog.scalascraper.model.Element
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class BaseParser(items: List[Element]) {
  def getItemPropText(itemPropName: String): List[Option[String]] = {
    val query: String = "[itemprop=\"" + itemPropName + "\"]"
    items.map(_ >?> text(query))
  }

  def getClassText(className: String): List[Option[String]] = {
    val query: String = "." + className
    items.map(_ >?> text(query))
  }

  def getClassElements(className: String): List[Option[List[Element]]] = {
    val query: String = "." + className
    items.map(_ >?> elementList(query))
  }

  def getTextWithQuery(query: String): List[Option[String]] = {
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
        case Some(value) =>
          if (value.nonEmpty) {
            listBuffer += value
          } else {
            listBuffer += ParserConstants.emptyStringValue
          }
        case None => listBuffer += ParserConstants.emptyStringValue
      }
    }
    listBuffer.toList
  }

  def optionsListToFirstElement(lists: List[Option[List[Element]]]): List[Element] = {
    for (list <- lists) {
      list match {
        case Some(list) =>
          if (list.nonEmpty)
            return list
        case None => // Do nothing.
      }
    }
    List.empty[Element]
  }

  def optionsListToFirstElement(values: List[Option[String]]): String = {
    for (value <- values) {
      value match {
        case Some(value) =>
          if (value.nonEmpty) {
            return value
          }
        case None => // Do nothing.
      }
    }
    ParserConstants.emptyStringValue
  }

  def optionsMapToAnyMap(optionsMap: mutable.Map[String, List[Option[String]]]): mutable.Map[String, Any] = {
    val map = mutable.Map[String, Any]()
    for (optionField <- optionsMap) {
      map += (optionField._1 -> optionsListToFirstElement(optionField._2))
    }
    map
  }
}
