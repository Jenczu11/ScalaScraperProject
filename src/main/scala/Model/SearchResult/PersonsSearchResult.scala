package Model.SearchResult

class PersonsSearchResult(override val name: String,
                          override val link: String,
                          val fullName: String,
                          val jobs: String)
  extends BaseSearchResult(name, link) {

  override def toString: String = {
    var output: String = s"$name"
    fullName match {
      case "---" => // Do nothing.
      case _ => output += s" ($fullName)"
    }
    jobs match {
      case "---" => // Do nothing.
      case _ => output += s", zawody: ${jobs.replaceAll(" ", ", ")}"
    }
    output
  }
}
