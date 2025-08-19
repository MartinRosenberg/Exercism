sealed trait NumberType

object NumberType {

  case object Perfect extends NumberType
  case object Abundant extends NumberType
  case object Deficient extends NumberType

  private def aliquatSum(n: Int): Int =
    (1 to n / 2).filter(n % _ == 0).distinct.sum

  def apply(n: Int): NumberType = aliquatSum(n) match {
    case `n`        => Perfect
    case s if s > n => Abundant
    case s if s < n => Deficient
  }

}
