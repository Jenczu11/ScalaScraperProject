package View

import Configuration.AppLanguage.userLang
import com.osinka.i18n.Messages

class MainView extends ViewBase() {
  def display(): Unit = {
    println(delimiter)
    print(
      Messages("mainview.title") + System.lineSeparator +
      delimiter + System.lineSeparator +
      Messages("mainview.searchmovie") + System.lineSeparator +
      Messages("mainview.searchpeople") + System.lineSeparator +
      Messages("mainview.searchcharacters") + System.lineSeparator +
      Messages("mainview.changelang") + System.lineSeparator +
      Messages("mainview.closeapp") + System.lineSeparator)
  }
}
