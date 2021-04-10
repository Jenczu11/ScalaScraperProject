package Model.SearchResult

import Parser.ParserConstants

class PersonsSearchResult(override val name: String,
                          override val link: String,
                          val fullName: String,
                          val jobs: String)
  extends BaseSearchResult(name, link) {

  override def toString: String = {
    var output: String = s"$name"
    fullName match {
      case ParserConstants.emptyStringValue => // Do nothing.
      case _ => output += s" ($fullName)"
    }
    jobs match {
      case ParserConstants.emptyStringValue => // Do nothing.
      case _ => output += s", zawody: ${jobs.replaceAll(" ", ", ")}"
    }
    output
  }
}
