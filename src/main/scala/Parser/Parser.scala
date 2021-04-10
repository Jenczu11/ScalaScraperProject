package Parser

import net.ruippeixotog.scalascraper.model.Element

trait Parser[T] {
    val items: List[Element]
    def parseItems(): List[T]
}
