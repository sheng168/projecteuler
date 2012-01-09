package poker

case class Hand(val cards:List[Card]) {
  def this(s: String) = this(Card.from(s).toList)
  
  val ace = 14
  
  def royal_flush = straight_flush && cards.maxBy(_.rank).rank == ace
  def straight_flush = straight && flush
  def four = kind(4) == 1
  def full_house = three && pair
  def flush = cards.sliding(2).forall(p => p(1).suit == p(0).suit)
  def straight = cards.sortBy(_.rank).sliding(2).forall(p => p(1).rank - p(0).rank == 1)
  def three = kind(3) == 1
  def pair2 = kind(2) == 2
  def pair = kind(2) == 1
  
  def groupRank = cards.groupBy(_.rank) 
  def of_kind(n: Int): scala.collection.immutable.Map[Int,List[poker.Card]] = {
    groupRank.filter(p => p._2.size == n)
  } 
  def kind(n: Int) = of_kind(n).size
  
  def rank = {
    if (royal_flush) {
      10
    } else if (straight_flush) {
      9
    } else if (four) {
      8
    } else if (full_house) {
      7
    } else if (flush) {
      6
    } else if (straight) {
      5
    } else if (three) {
      4
    } else if (pair2) {
      3
    } else if (pair) {
      2
    } else {
      1
    }
  }
  
  def >(that: Hand) = {
    val r1 = this.rank
    val r2 = that.rank

    if (r1 == r2) {
      if (r1 == 1) {
        this.cards(4).rank > that.cards(4).rank
      } else if (r1 == 2) {
        this.of_kind(2).values.toList(0)(0).rank > that.of_kind(2).values.toList(0)(0).rank
      } else {
        println("tie", this.rank, this, that.rank, that)
        false
      }
    } else {
      r1 > r2
    }
  }
  
}