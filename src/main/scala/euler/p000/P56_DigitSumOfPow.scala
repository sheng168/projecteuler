package euler.p000

import junit.framework._
import junit.framework.Assert.assertEquals
import scala.BigInt.apply

class P56 extends TestCase {
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
A googol (10100) is a massive number: one followed by one-hundred zeros; 100100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
*/