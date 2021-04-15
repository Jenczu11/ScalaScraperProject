package View

import Configuration.AppLanguage.userLang
import com.osinka.i18n.Messages

class ViewBase {
  val delimiter: String = Messages("delimiter")
  def askForChoice(): Unit = {
    print(Messages("askforchoice") + " ")
  }

  def givenNotANumber(): Unit = {
    print(Messages("givennotanumber") + System.lineSeparator)
  }
}
