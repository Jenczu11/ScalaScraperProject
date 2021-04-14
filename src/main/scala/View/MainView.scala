package View

import com.osinka.i18n.Messages

class MainView extends ViewBase() {
  def display(): Unit = {
    println(delimiter)
    print(
      Messages("title") + System.lineSeparator +
      delimiter + System.lineSeparator +
      Messages("searchmovie") + System.lineSeparator +
      Messages("searchpeople") + System.lineSeparator +
      Messages("searchcharacters") + System.lineSeparator +
      Messages("closeapp") + System.lineSeparator)
  }
}
