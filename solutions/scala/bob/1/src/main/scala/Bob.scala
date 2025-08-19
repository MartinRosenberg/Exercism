object Bob {

  def isQuestion(s: String): Boolean = s.endsWith("?")
  def isSilence(s: String): Boolean = s == ""
  def isYelling(s: String): Boolean = {
    val test = s.replaceAll("[^A-Za-z]", "")
    test.matches("[A-Z]+")
  }

  def response(statement: String): String = {
    statement.trim match {
      case s if isSilence(s) => "Fine. Be that way!"
      case s if isQuestion(s) && isYelling(s) => "Calm down, I know what I'm doing!"
      case s if isQuestion(s) => "Sure."
      case s if isYelling(s) => "Whoa, chill out!"
      case _ => "Whatever."
    }
  }

}
