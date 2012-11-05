package euler

import junit.framework._
import junit.framework.Assert.assertEquals

class P52 extends TestCase {
  import Assert._
  
  def isPermu(n: Long, x: Int) = {
    (1 to x).map(n * _).map(_.toString().sortWith(_ < _)).sliding(2).forall(p => p(0) == p(1))
  }

  def test13 {
    assertEquals(true, isPermu(125874, 2))
  }
  
  def testFind {
    assertEquals(142857, (1 until Int.MaxValue).find(isPermu(_, 5)).get)
  }

}
/*
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
*/