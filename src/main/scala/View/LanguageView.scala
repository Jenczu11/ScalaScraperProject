package View

import Configuration.AppLanguage

class LanguageView extends ViewBase() with View {
  def display(): Unit = {
    println(delimiter)
    println("Wybierz język jako jeden z możliwych (wprowadz pełną nazwę)")
    println("Dostępne języki: " + AppLanguage.availableLanguages.mkString(", "))
  }
}
