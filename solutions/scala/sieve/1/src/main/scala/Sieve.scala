import scala.collection.mutable

object Sieve {

  def primes(n: Int): List[Int] = {
    val xs = mutable.BitSet(2 to n: _*)
    for (i <- 2 to n) if (xs(i)) for (k <- i * i to n by i) xs -= k
    xs.toList
  }

}
