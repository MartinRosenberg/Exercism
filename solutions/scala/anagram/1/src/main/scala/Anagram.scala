object Anagram {

  def findAnagrams(word: String, candidates: Seq[String]): Seq[String] = {
    val lower = word.toLowerCase
    val sorted = lower.sorted
    candidates.filter { c =>
      val cLower = c.toLowerCase
      cLower != lower && cLower.sorted == sorted
    }
  }

}
