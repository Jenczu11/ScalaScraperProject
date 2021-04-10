package Model.SearchResult

class CharactersSearchResult(override val name: String,
                             override val link: String,
                             val numberOfLikes: String)
  extends BaseSearchResult(name, link) {

  override def toString: String = {
    var output: String = s"$name"
    numberOfLikes match {
      case "---" => // Do nothing.
      case _ => output += s", liczba polubień: $numberOfLikes"
    }
    output
  }
}
