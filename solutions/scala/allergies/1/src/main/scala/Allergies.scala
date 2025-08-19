import scala.collection.immutable.BitSet

object Allergies {

  type Score = Int

  private def toBitSet(score: Score): BitSet = BitSet.fromBitMask(Array(score))

  def allergicTo(allergen: Allergen.Value, score: Score): Boolean =
    toBitSet(score).contains(allergen.id)

  def list(score: Score): Seq[Allergen.Value] = {
    val bitSet = toBitSet(score)
    Allergen.values.filter(allergen => bitSet.contains(allergen.id)).toSeq
  }

}
