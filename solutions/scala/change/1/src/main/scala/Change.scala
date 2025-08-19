import scala.annotation.tailrec

object Change {

  /** Oh god, this requires a search algo. What do? */
  def findFewestCoins(amount: Int, coins: Seq[Int]): Option[Seq[Int]] = {
    if (amount == 0) Some(Nil)
    else if (amount < coins.head || coins.isEmpty) None
    else {
      @tailrec
      def run(amtLeft: Int, coinsLeft: Seq[Int], result: Seq[Int]): Option[Seq[Int]] = {
        (amtLeft, coinsLeft) match {
          case (a, l @ h :: _) if a > h => run(a - h, l, h +: result)
          case (a, h :: t) if a < h     => run(a, t, result)
          case (_, h :: _)              => Some(h +: result)
          case (_, Nil)                 => None
        }
      }
      run(amount, coins.reverse, Nil)
    }
  }

}
