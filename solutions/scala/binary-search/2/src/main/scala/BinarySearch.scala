import scala.annotation.tailrec

object BinarySearch {

  def find(elems: Seq[Int], elem: Int): Option[Int] = {
    val sorted = elems.sorted
    @tailrec
    def run(min: Int, max: Int): Option[Int] = (max + min) / 2 match {
      case mid if elem <  sorted(mid) & mid != 0   => run(min, mid - 1)
      case mid if elem >  sorted(mid) & mid != max => run(mid + 1, max)
      case mid if elem == sorted(mid)              => Some(mid)
      case _                                       => None
    }
    if (elems.isEmpty) None else run(0, sorted.length - 1)
  }

}
