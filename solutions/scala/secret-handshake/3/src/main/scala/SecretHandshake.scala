object SecretHandshake {
  private final val Reverse = 16
  private final val Components = Map(
    1 -> "wink",
    2 -> "double blink",
    4 -> "close your eyes",
    8 -> "jump"
  )

  def commands(sequence: Int): List[String] = {
    def hasComponent(bit: Int): Boolean = (sequence & bit) == bit
    val usedComponents = Components.filterKeys(hasComponent).values.toList
    if (hasComponent(Reverse)) usedComponents.reverse else usedComponents
  }
}
