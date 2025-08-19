object PerfectNumbers {

  def classify(n: Int): Either[String, NumberType] =
    if (n > 0) Right(NumberType(n))
    else Left("Classification is only possible for natural numbers.")

}
