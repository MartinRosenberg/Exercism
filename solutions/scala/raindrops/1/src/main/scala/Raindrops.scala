object Raindrops {

  private final val factors = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")

  def convert(n: Int, factors: Map[Int, String] = factors): String = {
    val words = factors.collect { case (factor, word) if n % factor == 0 => word }
    if (words.nonEmpty) words.mkString else n.toString
  }

}

