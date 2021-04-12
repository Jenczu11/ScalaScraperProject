package View

class ViewBase {
  val delimiter: String = "--------------------------------"

  def askForChoice(): Unit = {
    print("Twój wybór: ")
  }

  def givenNotANumber(): Unit = {
    print("Należy wpisać liczbę!" + System.lineSeparator)
  }
}
