case class Triangle(s1: Double, s2: Double, s3: Double) {

  val isTriangle: Boolean =
    s1 > 0 && s2 > 0 && s3 > 0

  lazy val degenerate: Boolean =
    isTriangle && ((s1 + s2 <= s3) || (s2 + s3 <= s1) || (s3 + s1 <= s2))

  lazy val equilateral: Boolean =
    isTriangle && s1 == s2 && s2 == s3

  lazy val isosceles: Boolean =
    isTriangle && !degenerate && (s1 == s2 || s2 == s3 || s3 == s1)

  lazy val scalene: Boolean =
    isTriangle && !degenerate && s1 != s2 && s2 != s3 && s3 != s1

}
