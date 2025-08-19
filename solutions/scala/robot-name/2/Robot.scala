package robot

import scala.collection.mutable
import scala.util.Random

class Robot() {

  def name: String = this._name

  var _name: String = Robot.replaceName(this._name)

  def reset(): Unit = {
    this._name = Robot.replaceName(this._name)
  }

}

object Robot {

  private val used: mutable.HashSet[String] = mutable.HashSet.empty[String]

  private def randomLetter(): Char = ('A' + Random.nextInt(26)).toChar

  private def randomDigit(): Char = ('0' + Random.nextInt(10)).toChar

  private def randomName(): String =
    ((0 until 2).map(_ => randomLetter()) ++ (0 until 3).map(_ => randomDigit())).mkString


  private def replaceName(oldName: String): String = {
    var newName = randomName()
    while (used.contains(newName)) {
      newName = randomName()
    }
    used += newName
    used -= oldName
    newName
  }

}