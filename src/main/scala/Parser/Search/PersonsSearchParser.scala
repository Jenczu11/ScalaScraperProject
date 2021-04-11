package Parser.Search

import Model.SearchResult.PersonsSearchResult
import Parser.BaseParser
import net.ruippeixotog.scalascraper.model.Element

import scala.collection.mutable.ListBuffer


class PersonsSearchParser(override val items: List[Element])
  extends BaseParser(items) with SearchParser[PersonsSearchResult] {

  def parseItems(): List[PersonsSearchResult] = {
    val names = getClassText("hit__title")
    val links = getLinkInClass("hit__title")
    val fullNames = getClassText("hit__real-name")
    val jobs = getClassText("hit__bioCatList")

    val namesList = optionsListToList(names)
    val linksList = optionsListToList(links)
    val fullNamesList = optionsListToList(fullNames)
    val jobsList = optionsListToList(jobs)

    val searchResultsListBuffer = ListBuffer[PersonsSearchResult]()
    val zippedList = namesList.lazyZip(linksList).lazyZip(fullNamesList).lazyZip(jobsList)
    for ((name, link, fullName, jobs) <- zippedList) {
      searchResultsListBuffer += new PersonsSearchResult(name, link, fullName, jobs)
    }
    searchResultsListBuffer.toList
  }
}
