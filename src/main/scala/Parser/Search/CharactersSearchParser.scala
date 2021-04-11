package Parser.Search

import Model.SearchResult.CharactersSearchResult
import Parser.BaseParser
import net.ruippeixotog.scalascraper.model.Element

import scala.collection.mutable.ListBuffer


class CharactersSearchParser(override val items: List[Element])
  extends BaseParser(items) with SearchParser[CharactersSearchResult] {

  def parseItems(): List[CharactersSearchResult] = {
    val names = getClassText("characterPreview__title")
    val links = getLinkInClass("characterPreview__title")
    val numbersOfLikes = getClassText("commonRating__countNumber")

    val namesList = optionsListToList(names)
    val linksList = optionsListToList(links)
    val numbersOfLikesList = optionsListToList(numbersOfLikes)

    val searchResultsListBuffer = ListBuffer[CharactersSearchResult]()
    val zippedList = namesList.lazyZip(linksList).lazyZip(numbersOfLikesList)
    for ((name, link, numberOfLikes) <- zippedList) {
      searchResultsListBuffer += new CharactersSearchResult(name, link, numberOfLikes)
    }
    searchResultsListBuffer.toList
  }
}
