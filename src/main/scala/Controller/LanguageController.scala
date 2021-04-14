package Controller

import Configuration.AppLanguage
import Downloader.DownloaderType
import View.LanguageView
import com.osinka.i18n.Lang

import scala.io.StdIn

class LanguageController extends BaseController with AppLanguage {
  def start(): Unit = {
    val languageView = new LanguageView()
    languageView.display()
    languageView.askForChoice()
    val languageChoice = StdIn.readLine()
    println(languageChoice)
    handleChoice(languageChoice)

    MainController.start()
    //    Messages("text")(globalconfiguration=Lang("en"));
  }

  private def handleChoice(choice: String): Unit = {
//    choice match {
//      case "en" => userLang = Lang("en")
//      case "pl" => userLang = Lang("pl")
////      case _ => userLang = Lang("en")
//    }
    if(choice == "pl") {
      println("elo polski")
      userLang = Lang("pl")
    }
    if(choice=="en") {
      println("elo eng")
      userLang = Lang("en")
    }

  }

}
