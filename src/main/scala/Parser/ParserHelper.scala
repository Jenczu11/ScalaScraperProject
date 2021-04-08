package Parser

import net.ruippeixotog.scalascraper.model.Element
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._

class ParserHelper {
  def getItemProp(items: List[Element], itemPropName: String): Any = {
    val query: String = "[itemprop=\"" + itemPropName + "\"]"
    items.map(_ >?> text(query))
  }
}
