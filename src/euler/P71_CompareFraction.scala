package euler

import junit.framework._

class P71 extends TestCase {
  import Assert._
  import math.Fraction
  
  def spirl(layer: Int) = {
    (1 to 1000).find(p => {val len = BigInt(2).pow(p).toString.size; println(len, p); len > p})
  }
  
  def find(d: Int, less: Fraction): Fraction = {
    var max = Fraction(0)
    
    for (d <- 2 to d) {
      for (n <- 1 until d) {
        val f = Fraction(n,d)
        
        if (max.toDouble < f.toDouble && f.toDouble < less.toDouble) {
          max = f
        }
      }
    }
    println(d, max)
    max
  }

  def find2(d: Int, less: Fraction): Fraction = {
    var max = Fraction(0)
    
    for (d <- 2 to d) {
      val n_d = less.toDouble * d
      var n = n_d.toInt
      
      var f = Fraction(n,d)
      
      do {
        f = Fraction(n,d)
        
        if (max.toDouble < f.toDouble && f.toDouble < less.toDouble) {
          max = f
        }
        n += 1
      } while (f.toDouble < less.toDouble)
    }
    println(d, max)
    max
  }

  def testFind {
    assertEquals(Fraction(2,5), find2(8, Fraction(3,7)))
    List(1, 10, 100, 1000).map(p => find2(p * 1000, Fraction(3, 7)))
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