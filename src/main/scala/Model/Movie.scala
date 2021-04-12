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
      ModelHelper.setField(this, name, value)
    }
  }

  override def toString: String = {
    var actorsString = ""
    for (actor <- actors) {
      actorsString += System.lineSeparator + " - " + actor
    }

    s"Film: $title" + System.lineSeparator +
    s"Reżyseria: $director" + System.lineSeparator +
    s"Scenariusz: $screenWriter" + System.lineSeparator +
    s"Gatunek: $genre" + System.lineSeparator +
    s"Rok produkcji: $productionYear" + System.lineSeparator +
    s"Czas trwania: $duration" + System.lineSeparator +
    s"Data premiery: $premiere" + System.lineSeparator +
    s"Aktorzy (role): $actorsString" + System.lineSeparator +
    "---------------------------------------------" + System.lineSeparator +
    s"Ocena: $rating" + System.lineSeparator +
    s"Liczba ocen: $numberOfRatings" + System.lineSeparator +
    s"Ocena krytyków: $criticsRating" + System.lineSeparator +
    s"Liczba ocen krytyków: $numberOfCriticsRatings" + System.lineSeparator +
    "---------------------------------------------" + System.lineSeparator +
    s"Opis: $description" + System.lineSeparator
  }
}
