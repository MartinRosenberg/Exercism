import scala.collection.immutable.SortedMap
import School._

class School {
  private var _db: DB = SortedMap.empty[Grade, Roster].withDefaultValue(Nil)

  def db: DB = _db

  def add(name: Name, grade: Grade): Unit = {
    _db += (grade -> (db(grade) :+ name))
  }

  def grade(grade: Grade): Roster = db(grade)

  def sorted: DB = db.mapValues(_.sorted)
}

object School {
  type Name = String
  type Grade = Int
  type Roster = Seq[Name]
  type DB = Map[Grade, Roster]
}
