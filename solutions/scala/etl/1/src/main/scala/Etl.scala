object Etl {

  type Letter = String
  type Score = Int

  def transform(lettersByScore: Map[Score, Seq[Letter]]): Map[Letter, Score] =
    lettersByScore.foldLeft(Map.empty[Letter, Score]){
      case (acc, (score, letters)) => acc ++ letters.map(_.toLowerCase -> score)
    }

}
