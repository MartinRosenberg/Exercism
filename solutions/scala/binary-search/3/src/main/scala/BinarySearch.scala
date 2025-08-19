import scala.annotation.tailrec

object BinarySearch {

  def find(elems: Seq[Int], elem: Int): Option[Int] = {
    val sorted = elems.toArray.sorted
    @tailrec
    def run(min: Int, max: Int): Option[Int] = {
      val mid = (max + min) / 2
      if (min > max) None
      else sorted(mid) match {
        case `elem`        => Some(mid)
        case x if elem < x => run(min, mid - 1)
        case x if elem > x => run(mid + 1, max)
      }
    }
    run(0, sorted.length - 1)
  }

}
