package Model

class Movie {
  val title: String = "title"
  val genre: String = "genre"
  val productionCountry: String = "country"
  val productionYear: String = "2000"
  val duration: String = "0 godz. 00 min."
  val premiere: String = "2000-01-01"
  val description: String = "description"

  val rating: Double = 0.0
  val criticsRating: Double = 0.0

  val directors: List[Person] = List.empty[Person]
  val actors: List[Person] = List.empty[Person]
  val screenWriters: List[Person] = List.empty[Person]
}
