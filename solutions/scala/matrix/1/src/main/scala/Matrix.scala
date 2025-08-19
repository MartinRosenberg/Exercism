case class Matrix(s: String) {

  private val matrix = s.split('\n').map(_.split(' ').map(_.toInt))

  def row(n: Int): Seq[Int] = matrix(n)

  def column(n: Int): Seq[Int] = matrix.map(_(n))

}
