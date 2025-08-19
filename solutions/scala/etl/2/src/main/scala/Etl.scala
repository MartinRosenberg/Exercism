object Etl {

  type Letter = String
  type Score = Int

  def transform(byScore: Map[Score, Seq[Letter]]): Map[Letter, Score] = for {
    (score, letters) <- byScore
    letter           <- letters
  } yield letter.toLowerCase -> score

}
