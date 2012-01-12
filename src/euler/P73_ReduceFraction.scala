package euler

import junit.framework._

class P73 extends TestCase {
  import Assert._
  import math.Fraction
  
  def find(d: Int) = {
    val half = .5
    val third = 1.0/3
    
    var count = 0
    
    for (d <- 2 to d) {
      for (n <- 1 until d) {
        val f = n.toDouble / d
        if (third < f && f < half && Fraction.gcd(n, d) == 1 ) {
          count += 1
          
          if (count % 10000000 == 0)
            print(".")
        }
      }
    }
    println
    println("count", d, count)
    count
  }

  def find2(d: Int, less: Fraction): Fraction = {
    var max = Fraction(0)
    
    max
  }

  def testFind {
    assertEquals(3, find(8))
    List(1000, 12000, 100000).map(p => find(p))
//    println("answer", find(1000000, Fraction(3,7)))
  }

}
/*
Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

If we list the set of reduced proper fractions for d ² 8 in ascending order of size, we get:

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

It can be seen that 2/5 is the fraction immediately to the left of 3/7.

By listing the set of reduced proper fractions for d ² 1,000,000 in ascending order of size, find the numerator of the fraction immediately to the left of 3/7.
*/