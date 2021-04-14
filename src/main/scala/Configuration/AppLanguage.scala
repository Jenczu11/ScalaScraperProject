package Configuration

import com.osinka.i18n.Lang

trait AppLanguage {
  implicit val userLang: Lang = Lang("pl")
}
