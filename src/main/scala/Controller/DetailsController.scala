package Controller

import Downloader.{Downloader, DownloaderFactory, DownloaderType}
import _root_.Downloader.DownloaderType.DownloaderType
import Model.SearchResult.{BaseSearchResult, CharactersSearchResult, MoviesSearchResult, PersonsSearchResult}
import Parser.Details.{CharacterDetailsParser, MovieDetailsParser, PersonDetailsParser}
import View.ObjectType.ObjectType
import View.{DetailView, ObjectType}


class DetailsController() extends BaseController {
  var searchDownloaderType: DownloaderType = DownloaderType.MoviesSearch
  var searchResult: BaseSearchResult = new BaseSearchResult("none", "none")
  var objectType: ObjectType = ObjectType.Movies
  var downloader: Downloader = DownloaderFactory.apply(DownloaderType.Details)
  var view: DetailView = new DetailView(ObjectType.Movies)

  def this(searchResult: BaseSearchResult, objectType: ObjectType, searchDownloaderType: DownloaderType) {
    this()
    this.searchResult = searchResult
    this.objectType = objectType
    this.searchDownloaderType = searchDownloaderType

    objectType match {
      case ObjectType.Movies => view = new DetailView(ObjectType.Movies)
      case ObjectType.Persons => view = new DetailView(ObjectType.Persons)
      case ObjectType.Characters => view = new DetailView(ObjectType.Characters)
    }
  }

  def start(): Unit = {
    val detailedObject = getDetailedObject
    view.displayDetails(detailedObject)
    view.displayOptions()
    view.askForChoice()

    val choice = integerPrompt(view)
    handleChoice(choice)
  }

  private def getDetailedObject: Any = {
    val elements = downloader.download(searchResult.link)

    var detailedObject : Any = null
    objectType match {
      case ObjectType.Movies =>
        detailedObject = new MovieDetailsParser(elements).parseItemsToObject()
      case ObjectType.Persons =>
        detailedObject = new PersonDetailsParser(elements).parseItemsToObject()
      case ObjectType.Characters =>
        detailedObject = new CharacterDetailsParser(elements).parseItemsToObject()
    }
    detailedObject
  }

  private def handleChoice(choice: Int): Unit = {
    if (choice == 0) {
      new SearchController(searchDownloaderType).start()
    } else {
      MainController.start()
    }
  }

}
