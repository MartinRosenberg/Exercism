object Bob {
  private def isQuestion(s: String) = s.endsWith("?")
  private def isYelling(s: String) = s.exists(_.isLetter) && s == s.toUpperCase
  private def isYellingQuestion(s: String) = isQuestion(s) && isYelling(s)
  private def isSilence(s: String) = s.isEmpty

  def response(statement: String): String = statement.trim match {
    case s if isSilence(s) => "Fine. Be that way!"
    case s if isYellingQuestion(s) => "Calm down, I know what I'm doing!"
    case s if isYelling(s) => "Whoa, chill out!"
    case s if isQuestion(s) => "Sure."
    case _ => "Whatever."
  }
}
