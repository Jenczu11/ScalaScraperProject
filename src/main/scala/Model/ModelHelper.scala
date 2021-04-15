package Model

import Parser.ParserConstants.maxWordsOfDescription

object ModelHelper {
  def setField(obj: Any, fieldName: String, fieldValue: Any) {
    obj.getClass.getDeclaredFields.find(_.getName == fieldName) match {
      case Some(field) =>
        field.setAccessible(true)
        field.set(obj, fieldValue)
      case None =>
        throw new IllegalArgumentException("No field named " + fieldName)
    }
  }

  def cutString(desc: String): String = {
    val temp = desc.split(" ")

    temp.toString
    var output: String = ""
    var iterator: Int = 0
    val words: Int = maxWordsOfDescription
    for (str <- temp) {
      output += str + " "
      iterator += 1
      if (iterator == words) {
        iterator = 0
        output += System.lineSeparator()
      }
    }
    output += System.lineSeparator()
    output
  }
}
