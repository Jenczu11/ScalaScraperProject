package Model

class BaseSearchResult(val name: String, val link: String) {
  override def toString = s"name: $name, link: $link"
}
