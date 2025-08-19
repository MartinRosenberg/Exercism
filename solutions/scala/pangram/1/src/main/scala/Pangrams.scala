object Pangrams {

  def sanitize(s: String): String = s.toLowerCase.replaceAll("[^a-z]", "")

  def isPangram(s: String): Boolean = sanitize(s).toSet == ('a' to 'z').toSet

}

