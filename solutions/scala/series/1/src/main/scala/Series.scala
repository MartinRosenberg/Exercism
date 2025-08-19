object Series {

  def slices(size: Int, s: String): Seq[Seq[Int]] =
    s.sliding(size).map(_.map(_.asDigit)).toSeq

}
