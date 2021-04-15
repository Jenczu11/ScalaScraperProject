package Controller

import View.ViewBase

import scala.io.StdIn

trait BaseController {
  def start()

  def integerPrompt(viewBase: ViewBase): Int = {
    var choice = -2
    while (choice == -2) {
      try {
        choice = StdIn.readInt()
      } catch {
        case _: NumberFormatException =>
          viewBase.givenNotANumber()
          viewBase.askForChoice()
      }
    }
    choice
  }
}
