object Isogram {

  def isIsogram(s: String): Boolean = {
    val sanitized = s.toLowerCase.replaceAll("[^a-z]", "")
    sanitized == sanitized.distinct
  }

}
