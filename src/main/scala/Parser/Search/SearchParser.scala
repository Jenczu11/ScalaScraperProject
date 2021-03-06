package Parser.Search

import net.ruippeixotog.scalascraper.model.Element

trait SearchParser[T] {
  val items: List[Element]

  def parseItemsToList(): List[T]
}
