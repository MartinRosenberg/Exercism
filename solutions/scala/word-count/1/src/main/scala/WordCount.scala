case class WordCount(words: String) {

  /** - include letters, numbers, apostrophes
    * - split on / ignore everything else
    */

  def countWords: Map[String, Int] =
    words
      .trim
      .toLowerCase
      .split("""([^a-z'\d]|\s)+|(^')|('$)""")
    .count()
      .groupBy(identity)
      .map { case (k, v) => k -> v.length }

}
