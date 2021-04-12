package Model

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
}
