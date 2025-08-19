object Series {

  def slices(size: Int, s: String): Seq[Seq[Int]] =
    s.map(_.asDigit).sliding(size).toSeq

}
