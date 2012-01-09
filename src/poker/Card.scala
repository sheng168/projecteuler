package poker

case class Card(val suit:Char, val rank: Int ) {
  assert(Card.suits.contains(suit), suit + " not in " + Card.suits)
  assert(2 <= rank && rank <= 14, rank + " not between 2 and 14")
}

object Card {
  val suits = Set('D', 'C', 'H', 'S')
  val ranks = Map('T'->10, 'J'->11, 'Q'->12, 'K'->13, 'A'->14)
  
  def toRank(c: Char) = {
    if (ranks.contains(c))
      ranks(c)
      else
        c.asDigit
  }
  
  def from(s: String) = {
    s.split(" ").map(c => Card(c(1), toRank(c(0))))
  }
  
  from("5H 5C 6S 7S KD")
}