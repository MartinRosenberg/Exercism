object Anagram {

  def findAnagrams(word: String, candidates: Seq[String]): Seq[String] =
    candidates
      .filterNot(_.equalsIgnoreCase(word))
      .filter(_.sorted.equalsIgnoreCase(word.sorted))

}
