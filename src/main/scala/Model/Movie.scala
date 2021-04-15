package Model

import com.osinka.i18n.Messages
import scala.collection.mutable
import Configuration.AppLanguage.userLang

class Movie extends {
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

    Messages("movie.title", title) + System.lineSeparator +
      Messages("movie.director", director) + System.lineSeparator +
      Messages("movie.screenWriter", screenWriter) + System.lineSeparator +
      Messages("movie.genre", genre) + System.lineSeparator +
      Messages("movie.productionYear", productionYear) + System.lineSeparator +
      Messages("movie.duration", duration) + System.lineSeparator +
      Messages("movie.premiere", premiere) + System.lineSeparator +
      Messages("movie.actors", actorsString) + System.lineSeparator +
      Messages("biggerdelimiter") + System.lineSeparator +
      Messages("movie.rating", rating) + System.lineSeparator +
      Messages("movie.numberOfRatings", numberOfRatings) + System.lineSeparator +
      Messages("movie.criticsRating", criticsRating) + System.lineSeparator +
      Messages("movie.numberOfCriticsRatings", numberOfCriticsRatings) + System.lineSeparator +
      Messages("biggerdelimiter") + System.lineSeparator +
//      Messages("movie.description", description.split("(?<=\\.)").mkString(System.lineSeparator())) + System.lineSeparator
      Messages("movie.description", description) + System.lineSeparator
  }
}
