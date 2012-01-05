package euler

import junit.framework._

class P243 extends TestCase {
  import Assert._
  
  def fact(n: Long) = {
    (2L until n).par.count(math.Fraction.gcd(n, _) != 1)
  }
  (2 to 48).foreach(n => println(n, fact(n)))

  def r(n: Long) = {
    1 + (2L until n).count(math.Fraction.gcd(n, _) == 1)
  }
  
  def rr(n: Long) = {
    r(n).toDouble / (n-1)
  }
  
  def find_r(t: Long, b: Long) = {
    val d: Double = t.toDouble / b
    println("finding",d)
    var min = 1.0
    val step = 223092870L//6469693230L//223092870//9699690
//    (step*4 until Int.MaxValue by step).find(n => {
//      val t = r(n).toDouble / (n-1)
//      if (t < min) {
//        println("min", n, t, d, t - d)
//        min = t
//      }
//      t < d
//    }).get
    var n = step*4
    while (min > d) {
      val t = r(n).toDouble / (n-1)
      if (t < min) {
        println("min", n, t, d, t - d)
        min = t
      }
      n += step
    }
    
    n
  }
  
  def testParse {
    (2 to 48).foreach(n => println(n, r(n)))
    assertEquals(4, r(12))
  }
  
  def testFind12 {
//    assertEquals(12, find_r(4, 10))
  }

  def testFind {
//    assertEquals(12, find_r(4, 10))
    assertEquals(12, find_r(15499, 94744))
  }
}
/*(1 to 19).map(n => n*n)
A positive fraction whose numerator is less than its denominator is called a proper fraction.
For any denominator, d, there will be d−1 proper fractions; for example, with d = 12:
1/12 , 2/12 , 3/12 , 4/12 , 5/12 , 6/12 , 7/12 , 8/12 , 9/12 , 10/12 , 11/12 .

We shall call a fraction that cannot be cancelled down a resilient fraction.
Furthermore we shall define the resilience of a denominator, R(d), to be the ratio of its proper fractions that are resilient; for example, R(12) = 4/11 .
In fact, d = 12 is the smallest denominator having a resilience R(d) < 4/10 .

Find the smallest denominator d, having a resilience R(d) < 15499/94744 .
*/