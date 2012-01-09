package poker

object Suit extends Enumeration {
  type Suit = Value
  
  val Diamond = Value("D")
  val Club = Value("C")
  val Heart = Value("H")
  val Spade = Value("S")
}