package Model

class CharactersSearchResult(override val name: String,
                             override val link: String,
                             val numberOfLikes: String)
  extends BaseSearchResult(name, link) {

  override def toString = s"name:$name, number of likes: $numberOfLikes, link:$link,"
}
