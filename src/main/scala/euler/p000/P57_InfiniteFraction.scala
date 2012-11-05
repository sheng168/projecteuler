package euler

import junit.framework._
import junit.framework.Assert.assertEquals
import math.BigFraction.apply
import scala.math.BigInt.int2bigInt

class P57 extends TestCase {
  import Assert._
  import math._
  
  def f(n: Int) = {
    var count = 0
    math.InfiniteFraction.series(2, n, p => {
      val exp = (p + BigFraction(1))
      if (exp.d.toString.size < exp.n.toString.size) {
        count += 1
      }
    })
    
    count
  }
  
  def testFind {
    assertEquals(1, f(8))
  }

  def testAnswer {
    assertEquals(153, f(1000))
  }
}
/*
It is possible to show that the square root of two can be expressed as an infinite continued fraction.

? 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...

By expanding this for the first four iterations, we get:

1 + 1/2 = 3/2 = 1.5
1 + 1/(2 + 1/2) = 7/5 = 1.4
1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...

The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.

In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
*/