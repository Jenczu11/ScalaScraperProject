package View

import com.osinka.i18n.Messages

class LanguageView extends ViewBase() with View {
  def display(): Unit = {
    println(delimiter)
    println("Wybierz język jako jeden z możliwych (wprowadz pełną nazwę)")
    println("Dostępne języki: "+availableLanguages.mkString(", "))
  }
}
