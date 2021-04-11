package Parser.Search

import Model.SearchResult.MoviesSearchResult
import Parser.{BaseParser, ParserConstants}
import net.ruippeixotog.scalascraper.model.Element

import scala.collection.mutable.ListBuffer


class MoviesSearchParser(override val items: List[Element])
  extends BaseParser(items) with SearchParser[MoviesSearchResult] {

  def parseItems(): List[MoviesSearchResult] = {
    val names = getClassText("filmPreview__title")
    val links = getLinkInClass("filmPreview__titleDetails")
    val genres = getClassText("filmPreview__info filmPreview__info--genres ul")
    val ratings = getItemText("ratingValue")

    val namesList = optionsListToList(names)
    val linksList = optionsListToList(links)
    val genresList = optionsListToList(genres)
    val ratingsList = optionsListToList(ratings)

    val searchResultsListBuffer = ListBuffer[MoviesSearchResult]()
    val zippedList = namesList.lazyZip(linksList).lazyZip(genresList).lazyZip(ratingsList)
    for ((name, link, genres, ratingString: String) <- zippedList) {
      var ratingDouble: Double = ParserConstants.emptyGradesValue
      if (!ratingString.equals(ParserConstants.emptyStringValue)) {
        ratingDouble = ratingString.replaceAll(",", ".").toDouble
      }
      searchResultsListBuffer += new MoviesSearchResult(name, link, genres, ratingDouble)
    }
    searchResultsListBuffer.toList
  }
}