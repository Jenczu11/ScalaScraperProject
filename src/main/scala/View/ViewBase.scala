package View

import Configuration.AppLanguage
import com.osinka.i18n.{Lang, Messages}

class ViewBase extends AppLanguage {
  val delimiter: String = Messages("delimiter")
  def askForChoice(): Unit = {
    print(Messages("askforchoice"))
  }

  def givenNotANumber(): Unit = {
    print(Messages("givennotanumber") + System.lineSeparator)
  }
}
