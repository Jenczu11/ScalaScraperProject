package Controller

import Downloader.DownloaderType
import View.MainView
import scala.io.StdIn

object MainController extends BaseController  {
  def start(): Unit = {
    val mainView = new MainView()
    mainView.display()
    mainView.askForChoice()
    var choice = 0
    while (choice == 0) {
      try {
        choice = StdIn.readInt()
      } catch {
        case _: NumberFormatException =>
          mainView.givenNotANumber()
          mainView.askForChoice()
      }
    }
    handleChoice(choice)
  }

  private def handleChoice(choice: Int): Unit = {
    choice match {
      case 1 => new SearchController(DownloaderType.MoviesSearch).start()
      case 2 => new SearchController(DownloaderType.PersonsSearch).start()
      case 3 => new SearchController(DownloaderType.CharactersSearch).start()
      case 4 => new LanguageController().start()
      case _ => System.exit(0)
    }
  }
}
