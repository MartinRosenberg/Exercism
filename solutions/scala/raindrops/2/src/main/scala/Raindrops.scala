object Raindrops {

  private final val factors = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")

  def convert(n: Int, factors: Map[Int, String] = factors): String = {
    val words = factors.filterKeys(n % _ == 0).values
    if (words.nonEmpty) words.mkString else n.toString
  }

}

