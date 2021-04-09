package Parser

import Model.{BaseSearchResult, CharactersSearchResult}
import net.ruippeixotog.scalascraper.model.Element
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._

import scala.collection.mutable.ListBuffer


class CharactersSearchParser(items: List[Element]) extends BaseParser(items) {

  def parseToResultList(): List[BaseSearchResult] = {
    val names = getClassText("characterPreview__title")
    val links = getLinkInClass("characterPreview__title")
    val numbersOfLikes = getClassText("commonRating__countNumber")

    val namesList = optionsListToList(names)
    val linksList = optionsListToList(links)
    val numbersOfLikesList = optionsListToList(numbersOfLikes)

    val searchResultsListBuffer = ListBuffer[BaseSearchResult]()
    val superList = namesList.lazyZip(linksList).lazyZip(numbersOfLikesList)
    for ((name, link, numberOfLikes) <- superList) {
      searchResultsListBuffer += new CharactersSearchResult(name, link, numberOfLikes)
    }
    searchResultsListBuffer.toList
  }
}
