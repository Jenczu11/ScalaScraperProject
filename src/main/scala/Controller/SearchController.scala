package Controller

import Downloader.{Downloader, DownloaderFactory, DownloaderType}
import Model.SearchResult.BaseSearchResult
import Parser.Search.{CharactersSearchParser, MoviesSearchParser, PersonsSearchParser}
import View.ObjectType.ObjectType
import View.{ObjectType, SearchView}
import _root_.Downloader.DownloaderType.DownloaderType

import scala.io.StdIn

class SearchController {
  var objectType: ObjectType = ObjectType.Movies
  var downloaderType: DownloaderType = DownloaderType.MoviesSearch
  var downloader: Downloader = DownloaderFactory.apply(downloaderType)
  var view: SearchView = new SearchView(ObjectType.Movies)

  def this(dt: DownloaderType) {
    this()
    this.downloaderType = dt
    this.downloader = DownloaderFactory.apply(downloaderType)
    downloaderType match {
      case DownloaderType.MoviesSearch =>
        this.objectType = ObjectType.Movies
        view = new SearchView(ObjectType.Movies)
      case DownloaderType.PersonsSearch =>
        this.objectType = ObjectType.Persons
        view = new SearchView(ObjectType.Persons)
      case DownloaderType.CharactersSearch =>
        this.objectType = ObjectType.Characters
        view = new SearchView(ObjectType.Characters)
    }
  }

  def start(): Unit = {
    view.display()
    val searchText = StdIn.readLine()
    val results = search(searchText)

    view.displaySearchResults(results)
    view.displayOptions(results.size)
    view.askForChoice()
    val choice = StdIn.readInt()

    if (results.nonEmpty && choice >= 1 && choice <= results.size) {
      new DetailsController(results(choice - 1), objectType).start()
    } else if (choice == 0) {
      new SearchController(downloaderType).start()
    } else {
      MainController.start()
    }

  }

  private def search(searchText: String): List[BaseSearchResult] = {
    val elements = downloader.download(searchText)

    var results: List[BaseSearchResult] = List.empty
    downloaderType match {
      case DownloaderType.MoviesSearch =>
        results = new MoviesSearchParser(elements).parseItemsToList()
      case DownloaderType.PersonsSearch =>
        results = new PersonsSearchParser(elements).parseItemsToList()
      case DownloaderType.CharactersSearch =>
        results = new CharactersSearchParser(elements).parseItemsToList()
    }
    results
  }
}
