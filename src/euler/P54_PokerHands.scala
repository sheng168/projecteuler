package euler

import junit.framework._
import poker._

class P54 extends TestCase {
  import Assert._
  
  def digitSum(n: BigInt) = {
    n.toString().map(_.asDigit).sum
  }
  
  def digSumPow(a: Int, b: Int) = {
    digitSum(BigInt(a).pow(b))
  }

  def test_2 {
    assertEquals(true, new Hand("5H 5C 6S 7S KD").pair)
  }
  def test_2_rank {
    assertEquals(true, new Hand("5H 5C 6S 7S KD").pair)
    assertEquals(5, new Hand("5H 5C 6S 7S KD").of_kind(2).values.toList(0)(0).rank)
  }
  def test_3 {
    assertEquals(true, new Hand("2D 9C AS AH AC").three)
  }
  def test_flush {
    assertEquals(true, new Hand("3D 6D 7D TD QD").flush)
  }
  def test_full {
    assertEquals(true, new Hand("2H 2D 4C 4D 4S").three)
  }
  
  def test100_100 {
//    assertEquals(1, digSumPow(100, 100))
  }

  def testFind {
    val games = io.Source.fromFile("p54_poker.txt").getLines.map(Card.from(_).toList).map(_.splitAt(5)).toList
//    games.foreach(println)
    
    val p1 = games.map(p => (new Hand(p._1.sortBy(_.rank)), new Hand(p._2.sortBy(_.rank)))).map(p => p._1 > p._2).filter(b => b).size
    
    println(p1)
    assertEquals(1000, p1)
  }

}
/*
In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:

    High Card: Highest value card.
    One Pair: Two cards of the same value.
    Two Pairs: Two different pairs.
    Three of a Kind: Three cards of the same value.
    Straight: All cards are consecutive values.
    Flush: All cards of the same suit.
    Full House: Three of a kind and a pair.
    Four of a Kind: Four cards of the same value.
    Straight Flush: All cards are consecutive values of same suit.
    Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

The cards are valued in the order:
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

If two players have the same ranked hands then the rank made up of the highest value wins; for example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for example, both players have a pair of queens, then highest cards in each hand are compared (see example 4 below); if the highest cards tie then the next highest cards are compared, and so on.

Consider the following five hands dealt to two players:
Hand	 	Player 1	 	Player 2	 	Winner
1	 	5H 5C 6S 7S KD
Pair of Fives
	 	2C 3S 8S 8D TD
Pair of Eights
	 	Player 2
2	 	5D 8C 9S JS AC
Highest card Ace
	 	2C 5C 7D 8S QH
Highest card Queen
	 	Player 1
3	 	2D 9C AS AH AC
Three Aces
	 	3D 6D 7D TD QD
Flush with Diamonds
	 	Player 2
4	 	4D 6S 9H QH QC
Pair of Queens
Highest card Nine
	 	3D 6D 7H QD QS
Pair of Queens
Highest card Seven
	 	Player 1
5	 	2H 2D 4C 4D 4S
Full House
With Three Fours
	 	3C 3D 3S 9S 9D
Full House
with Three Threes
	 	Player 1

The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the file contains ten cards (separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards. You can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order, and in each hand there is a clear winner.

How many hands does Player 1 win?
*/