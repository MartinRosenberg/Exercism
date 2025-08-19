object Hamming {

  def distance(a: String, b: String): Option[Int] =
    if (a.length != b.length) None
    else Some(a.zip(b).count(_ != _))

}
