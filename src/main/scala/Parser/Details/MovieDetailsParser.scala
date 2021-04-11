package Parser.Details

import Model.Movie
import Parser.BaseParser
import net.ruippeixotog.scalascraper.model.Element

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class MovieDetailsParser (override val items: List[Element])
  extends BaseParser(items) with DetailsParser[Movie] {

  override def parseItemsToObject(): Movie = {
    val movieFields = parseMainMovieFields()
    movieFields += ("actors" -> parseActorsElements())

    new Movie(movieFields)
  }

  private def parseMainMovieFields(): mutable.Map[String, Any] = {
    val movieOptionsFieldsMap = mutable.Map[String, List[Option[String]]](
      "title" -> getClassText("filmCoverSection__title"),
      "genre" -> getItemPropText("genre"),
      "productionYear" -> getClassText("filmCoverSection__year"),
      "duration" -> getClassText("filmCoverSection__filmTime"),
      "premiere" -> getTextWithQuery("[href$=\"dates\"]"),
      "description" -> getItemPropText("description"),
      "rating" -> getTextWithQuery(".filmRating--hasPanel .filmRating__rateValue"),
      "numberOfRatings" -> getTextWithQuery(".filmRating--hasPanel .filmRating__count"),
      "criticsRating" -> getTextWithQuery(".filmRating--filmCritic .filmRating__rateValue"),
      "numberOfCriticsRatings" -> getTextWithQuery(".filmRating--filmCritic .filmRating__count"),
      "director" -> getItemPropText("director"),
      "screenWriter" -> getItemPropText("creator")
    )
    val movieFieldsMap = mutable.Map[String, Any]()
    for (optionField <- movieOptionsFieldsMap) {
      movieFieldsMap += (optionField._1 -> optionsListToFirstElement(optionField._2))
    }
    movieFieldsMap
  }

  private def parseActorsElements(): List[String] = {
    val actorsElements = getClassElements("personRole__container")
    val actors = optionsListToFirstElement(actorsElements)

    val baseParser = new BaseParser(actors)
    val actorsNames = baseParser.getClassText("personRole__person")
    val roleNames = baseParser.getClassText("personRole__role")

    val actorsNamesList = baseParser.optionsListToList(actorsNames)
    val roleNamesList = baseParser.optionsListToList(roleNames)

    val zippedList = actorsNamesList.lazyZip(roleNamesList)

    var actorsList = ListBuffer[String]()
    for ((actor, role) <- zippedList) {
      actorsList += actor + " (" + role + ")"
    }
    actorsList.toList
  }
}
