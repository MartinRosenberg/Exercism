import scala.collection.mutable
import scala.util.Try

case class PalindromeProducts(start: Int, end: Int) {

  type Factor = Int
  type FactorPair = (Factor, Factor)
  type Product = Int

  def isPalindrome(n: Product): Boolean = {
    val s = n.toString
    s == s.reverse
  }

  val palindromeProducts: Map[Product, Set[FactorPair]] = (start to end)
    .flatMap(i => (i to end).map(k => i * k -> (i, k)))
    .filter { case (prod, _) => isPalindrome(prod) }
    .foldLeft(mutable.Map[Product, Set[FactorPair]]().withDefaultValue(Set())) {
      case (acc, (prod, (i, k))) =>
        acc(prod) += ((i, k))
        acc
    }
    .toMap

  def smallest: Option[(Product, Set[FactorPair])] =
    Try(palindromeProducts.minBy { case (p, _) => p }).toOption

  def largest: Option[(Product, Set[FactorPair])] =
    Try(palindromeProducts.maxBy { case (p, _) => p }).toOption

}
