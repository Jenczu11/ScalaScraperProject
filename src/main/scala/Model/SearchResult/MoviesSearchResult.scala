package Model.SearchResult

import Parser.ParserConstants

class MoviesSearchResult(override val name: String,
                         override val link: String,
                         val genre: String,
                         val rating: Double)
  extends BaseSearchResult(name, link) {

  override def toString: String = {
    var output: String = s"$name"

    rating match {
      case ParserConstants.emptyGradesValue => output += " (brak ocen)"
      case _ => output += s", ocena: $rating"
    }
    genre match {
      case ParserConstants.emptyStringValue => // Do nothing.
      case _ => output += s", gatunek: ${genre.replaceAll(" ", ", ")}"
    }
    output
  }
}
