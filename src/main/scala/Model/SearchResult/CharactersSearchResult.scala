package Model.SearchResult

import Parser.ParserConstants

class CharactersSearchResult(override val name: String,
                             override val link: String,
                             val numberOfLikes: String)
  extends BaseSearchResult(name, link) {

  override def toString: String = {
    var output: String = s"$name"
    numberOfLikes match {
      case ParserConstants.emptyStringValue => // Do nothing.
      case _ => output += s", liczba polubień: $numberOfLikes"
    }
    output
  }
}
