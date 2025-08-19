case class Matrix(matrix: Seq[Seq[Int]]) {

  type Coordinate = (Int, Int)

  private val transposed = matrix.transpose

  private val isSaddlePoint: Coordinate => Boolean = { case (y, x) =>
    val point = matrix(y)(x)
    matrix(y).max == point && transposed(x).min == point
  }

  lazy val saddlePoints: Set[Coordinate] =
    (for {
      y <- matrix.indices
      x <- matrix.head.indices
      if isSaddlePoint((y, x))
    } yield (y, x)).toSet

}
