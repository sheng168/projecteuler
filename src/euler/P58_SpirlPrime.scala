package euler

import junit.framework._
import math.BigFraction

class P58 extends TestCase {
  import Assert._
  
  def digitSum(n: BigInt) = {
    n.toString().map(_.asDigit).sum
  }
  
  def digSumPow(a: Int, b: Int) = {
    digitSum(BigInt(a).pow(b))
  }

  def test10_100 {
    assertEquals(1, digSumPow(10, 100))
  }
  def test100_100 {
    assertEquals(1, digSumPow(100, 100))
  }

  def testFind {
//    assertEquals(142857, (1 until Int.MaxValue).find(isPermu(_, 5)).get)
//    (1 until 100).map(isLychrel(_)).foreach(println)
    
//    var greater = 0
//    var less = 0
    val s = for (a <- 1 until 100; b <- 1 until 100) yield digSumPow(a, b)
    
    
    {
//      val ncr = isLychrel(n)
//
//      if (ncr) {
//        greater += 1
//      } else {
//        less += 1
//      }
    }
    
//    println(greater, less)
    println("answer", s.max, s.min)
    assertEquals(972, s.max)
  }

}
/*
Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.

37 36 35 34 33 32 31
38 17 16 15 14 13 30
39 18  5  4  3 12 29
40 19  6  1  2 11 28
41 20  7  8  9 10 27
42 21 22 23 24 25 26
43 44 45 46 47 48 49

It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 Å 62%.

If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?
*/