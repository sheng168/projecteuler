package euler

import junit.framework._
import math.BigFraction

class P53 extends TestCase {
  import Assert._
  
  def fact(n: Long) = {
    assert(n >= 0)
    
    if (n <= 1)
      BigInt(1)
      else
        (2L to n).map(BigInt(_)).product
  }

  def nChooseR(n: Long, r: Long) = {
    (fact(n)/fact(r)/fact(n-r))
  }

  def test53 {
    assertEquals(BigInt(10), nChooseR(5, 3))
  }
  
  def test55 {
    assertEquals(BigInt(1), nChooseR(5, 5))
  }
  def test50 {
    assertEquals(BigInt(1), nChooseR(5, 0))
  }

  def test23_10 {
    assertEquals(BigInt(1144066), nChooseR(23, 10))
  }
  
  def testFind {
//    assertEquals(142857, (1 until Int.MaxValue).find(isPermu(_, 5)).get)
    (0 to 23).map(fact(_)).foreach(println)
    
    var greater = 0
    var less = 0
    for (n <- 1 to 100; r <- 1 to n) {
      val ncr = nChooseR(n, r)
      println(n, r, ncr)
      if (ncr > 1000000) {
        greater += 1
      } else {
        less += 1
      }
    }
    
    println(greater, less)
  }

}
/*
There are exactly ten ways of selecting three from five, 12345:

123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

In combinatorics, we use the notation, 5C3 = 10.

In general,
nCr = 	
n!
r!(n−r)!
	,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.

It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.

How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?
*/