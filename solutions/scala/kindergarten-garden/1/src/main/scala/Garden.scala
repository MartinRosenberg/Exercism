import Plant._

case class Garden(garden: Seq[(Plant, Plant)]) {

  def plants(student: String): Seq[Plant] = {
    val studNum = Student.withName(student).id
    garden
      .grouped(2)
      .toSeq
      .slice(studNum, studNum + 1)
      .flatMap { case Seq((p1, p2), (p3, p4)) => Seq(p1, p3, p2, p4) }
  }

}

object Garden {

  def defaultGarden(s: String): Garden = {
    val Array(row1, row2) = s.split('\n').map(_.map(Plant(_)))
    Garden(row1.zip(row2))
  }

}
