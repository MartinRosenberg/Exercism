import scala.annotation.tailrec

object BinarySearch {

  def find(elems: Seq[Int], elem: Int): Option[Int] = {
    val sorted = elems.sorted
    @tailrec
    def run(min: Int, max: Int): Option[Int] = (max - min) / 2 + min match {
      case p if elem == sorted(p)            => Some(p)
      case p if elem <  sorted(p) & p != 0   => run(0, p - 1)
      case p if elem >  sorted(p) & p != max => run(p + 1, max)
      case _                                 => None
    }
    if (elems.isEmpty) None else run(0, sorted.length - 1)
  }

}
