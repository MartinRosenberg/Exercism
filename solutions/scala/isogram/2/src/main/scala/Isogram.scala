object Isogram {

  def isIsogram(s: String): Boolean = {
    val normalized = s.collect { case c if c.isLetter => c.toLower }
    normalized == normalized.distinct
  }

}
