package Model

object PersonType extends Enumeration {
  type PersonType = Value
  val Actor, Director, Producer, Compozer, CameraOperator, AsHimself, AsGuest, Dubbing = Value

  def mapFromString(personType: String): PersonType = {
    personType match {
      case "aktor" => PersonType.Actor
      case "reżyser" => PersonType.Director
      case "producent" => PersonType.Producer
      case "kompozytor" => PersonType.Compozer
      case "operator" => PersonType.CameraOperator
      case "we własnej osobie" => PersonType.AsHimself
      case "gościnnie" => PersonType.AsGuest
      case "dubbing" => PersonType.Dubbing
      case _ => PersonType.Actor
    }
  }
}
