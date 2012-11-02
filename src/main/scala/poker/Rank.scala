package poker

sealed trait Rank {
//  def name: String
  def rank: Int
}

case object A extends Rank {
  val rank = 14
}