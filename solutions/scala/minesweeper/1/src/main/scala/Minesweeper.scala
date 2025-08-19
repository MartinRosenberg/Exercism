import Minesweeper._

// This is all terrible. Please forgive me.
case class Minesweeper(rows: Seq[Row]) {

  final val Height = rows.length
  final val Width = rows.headOption.map(_.length).getOrElse(0)

  def checkNeighbors(res: Array[Array[Int]])(pos: Position): Unit =
    pos match { case (yo, xo) =>
      for {
        y <- yo - 1 to yo + 1 if y >= 0 && y < Height
        x <- xo - 1 to xo + 1 if x >= 0 && x < Width
        if (y, x) != (yo, xo) && isMine(res(y)(x))
      } {
        val cell = res(yo)(xo)
        res(yo)(xo) = (cell + 1).toChar
      }
    }

  val annotated: Seq[Row] = {
    val res = rows.toArray.map(_.toArray.map(_.toInt))
    val checkOurNeighbors = checkNeighbors(res)_
    for {
      (row,  y) <- rows.zipWithIndex
      (cell, x) <- row.zipWithIndex
      if !isMine(cell)
    } checkOurNeighbors((y, x))
    res.toList.map(_.map { c => (
      if ("* ".contains(c)) c
      else c + 16
    ).toChar }.mkString)
  }

}

object Minesweeper {

  type Row = String

  type Position = (Int, Int)

  private def isMine(c: Int): Boolean = c == '*'

  def annotate(rows: Seq[Row]): Seq[Row] = Minesweeper(rows).annotated

}
