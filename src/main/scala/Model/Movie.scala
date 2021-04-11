package Model

import scala.collection.mutable

class Movie {
  val title: String = "title"
  val genre: String = "genre"
  val productionYear: String = "2000"
  val duration: String = "0 godz. 00 min."
  val premiere: String = "2000-01-01"
  val description: String = "description"

  val rating: String = "0.0"
  val numberOfRatings: String = "0"
  val criticsRating: String = "0.0"
  val numberOfCriticsRatings: String = "0"

  val director: String = "director"
  val screenWriter: String = "screen writer"
  val actors: List[String] = List.empty[String]

  def this(fields: mutable.Map[String, Any]) {
    this()
    for ((name, value) <- fields) {
      this.setField(name, value)
    }
  }

  private def setField(fieldName: String, fieldValue: Any) {
    this.getClass.getDeclaredFields.find(_.getName == fieldName) match {
      case Some(field) =>
        field.setAccessible(true)
        field.set(this, fieldValue)
      case None =>
        throw new IllegalArgumentException("No field named " + fieldName)
    }
  }

  override def toString: String = s"Movie(" +
    s"$title, $genre, $productionYear, $duration, $premiere, " +
    s"$description, $rating, $numberOfRatings, $criticsRating, " +
    s"$numberOfCriticsRatings, $director, $screenWriter, $actors)"
}
