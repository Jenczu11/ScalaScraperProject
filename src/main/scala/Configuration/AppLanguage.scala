package Configuration

import com.osinka.i18n.Lang

object AppLanguage {
  implicit var userLang: Lang = Lang("en")
  val availableLanguages: List[String] = List("en","pl")
}
