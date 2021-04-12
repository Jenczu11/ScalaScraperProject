package View

class MainView extends ViewBase() {
  def display(): Unit = {
    print(
      "Filmweb scrapper" + System.lineSeparator +
      delimiter + System.lineSeparator +
      "1. Wyszukaj filmu" + System.lineSeparator +
      "2. Wyszukaj ludzi kina" + System.lineSeparator +
      "3. Wyszukaj postaci" + System.lineSeparator +
      "4. Zamknij aplikację" + System.lineSeparator)
  }
}
