object Acronym {

  def abbreviate(phrase: String): String =
    phrase.toUpperCase.split("[^A-Z']+").map(_.head).mkString

}
