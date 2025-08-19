case class Matrix(s: String) {

  private lazy val rows = s.split("\\R").map(_.split(' ').map(_.toInt))

  private lazy val columns = rows.head.indices.map(n => rows.map(_(n)))

  def row(n: Int): Seq[Int] = rows(n)

  def column(n: Int): Seq[Int] = columns(n)

}
