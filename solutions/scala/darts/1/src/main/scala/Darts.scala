object Darts {

  def score(x: Double, y: Double): Int =
    Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) match {
      case d if d <= 1  => 10
      case d if d <= 5  => 5
      case d if d <= 10 => 1
      case _            => 0
    }

}
