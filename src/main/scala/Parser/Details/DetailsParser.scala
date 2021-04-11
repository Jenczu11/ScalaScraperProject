package Parser.Details

import net.ruippeixotog.scalascraper.model.Element

trait DetailsParser[T] {
  val items: List[Element]

  def parseItemsToObject(): T
}
