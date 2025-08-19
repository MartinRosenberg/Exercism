import SpiralMatrix.Direction._

object SpiralMatrix {

//  final class Direction
//  object Direction {
//    val Right: Direction = new Direction
//    val Down: Direction = new Direction
//    val Left: Direction = new Direction
//    val Up: Direction = new Direction
//
//    val pivot: Iterator[Direction] = Iterator.iterate(Right) {
//      case Right => Down
//      case Down => Left
//      case Left => Up
//      case Up => Right
//    }
//  }

  sealed trait Direction
  object Direction {
    case object Right extends Direction
    case object Down extends Direction
    case object Left extends Direction
    case object Up extends Direction

    val pivot: Iterator[Direction] = Iterator.iterate[Direction](Right) {
      case Right => Down
      case Down => Left
      case Left => Up
      case Up => Right
    }
  }

  case class Position(row: Int, col: Int) {
    def next(direction: Direction): Position = direction match {
      case Right => Position(row, col + 1)
      case Down => Position(row + 1, col)
      case Left => Position(row, col - 1)
      case Up => Position(row - 1, col)
    }
  }

  def spiralMatrix(size: Int): Seq[Seq[Int]] = {
    val grid = Array.fill(size)(Array.fill(size)(0))
    var dir: Direction = Right
    var pos = Position(0, 0)

    def isOutsideGrid(pos: Position): Boolean =
      pos.row < 0 || pos.row >= size || pos.col < 0 || pos.col >= size

    for (n <- 1 to size * size) {
      grid(pos.row)(pos.col) = n
      pos = if (isOutsideGrid(pos.next(dir))) {
        dir = Direction.pivot.next()
        pos.next(dir)
      } else {
        pos.next(dir)
      }
    }

    grid.map(_.toList).toList
  }

}
