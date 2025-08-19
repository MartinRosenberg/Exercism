object Pangrams {

  def isPangram(s: String): Boolean =
    (('a' to 'z').toSet -- s.toLowerCase.toSet).isEmpty

}
