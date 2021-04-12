package Controller

import Downloader.{Downloader, DownloaderFactory, DownloaderType}
import Model.SearchResult.BaseSearchResult
import Parser.Search.{CharactersSearchParser, MoviesSearchParser, PersonsSearchParser}
import View.{SearchType, SearchView}
import _root_.Downloader.DownloaderType.DownloaderType
import scala.io.StdIn

class SearchController {
  var downloaderType: DownloaderType = DownloaderType.MoviesSearch
  var downloader: Downloader = DownloaderFactory.apply(downloaderType)
  var view: SearchView = new SearchView(SearchType.Movies)

  def this(dt: DownloaderType) {
    this()
    this.downloaderType = dt
    this.downloader = DownloaderFactory.apply(downloaderType)
    downloaderType match {
      case DownloaderType.MoviesSearch => this.view = new SearchView(SearchType.Movies)
      case DownloaderType.PersonsSearch => this.view = new SearchView(SearchType.Persons)
      case DownloaderType.CharactersSearch => this.view = new SearchView(SearchType.Characters)
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

    choice match {
      case 1 => new SearchController(DownloaderType.MoviesSearch).start()
      case 2 => new SearchController(DownloaderType.PersonsSearch).start()
      case 3 => new SearchController(DownloaderType.CharactersSearch).start()
      case _ => System.exit(0)
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
