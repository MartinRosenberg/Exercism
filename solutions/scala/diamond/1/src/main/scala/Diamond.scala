object Diamond {
  def rows(end: Char): List[String] = {
    val letters = 'A' to end
    val size = letters.length
    val top = letters
      .zipWithIndex
      .map { case (c, i) => s"%${size - i}s".format(c).padTo(size, ' ') }
      .map(row => row ++ row.reverse.tail)
    (top ++ top.reverse.tail).toList
  }
}
