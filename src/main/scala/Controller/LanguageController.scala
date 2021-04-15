package Controller

import Configuration.AppLanguage.userLang
import View.LanguageView
import com.osinka.i18n.Lang

import scala.io.StdIn

class LanguageController extends BaseController  {
  def start(): Unit = {
    val languageView = new LanguageView()
    languageView.display()
    languageView.askForChoice()
    val languageChoice = StdIn.readLine()
    handleChoice(languageChoice)

    MainController.start()
  }

  private def handleChoice(choice: String): Unit = {
        choice match {
          case "en" => userLang = Lang("en")
          case "pl" => userLang = Lang("pl")
          case _ => userLang = Lang("en")
        }
  }

}
