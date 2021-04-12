package Model

object PersonType extends Enumeration {
  type PersonType = Value
  val Actor: Model.PersonType.Value = Value("Aktor")
  val Director: Model.PersonType.Value = Value("Reżyser")
  val Producer: Model.PersonType.Value = Value("Producent")
  val Compozer: Model.PersonType.Value = Value("Kompozytor")
  val CameraOperator: Model.PersonType.Value = Value("Operator kamery")
  val AsHimself: Model.PersonType.Value = Value("We własnej osobie")
  val AsGuest: Model.PersonType.Value = Value("Gościnnie")
  val Dubbing: Model.PersonType.Value = Value("Dubbing")

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
