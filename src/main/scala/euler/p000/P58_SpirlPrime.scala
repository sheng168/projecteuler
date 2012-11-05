package euler

import junit.framework._
import euler.Prime

class P58 extends TestCase {
  import Assert._
  
  def spirl(layer: Int) = {
    
  }
  
  def find(ratio: Double): Int = {
    var dia = 1
    var primes = 0
    for (layer <- 1 until Int.MaxValue) {
      for (n <- 1 to 4) {
        dia += 2 * layer
        if (Prime.isPrime(dia)) {
          primes +=1
        }
        println(layer, dia)
      }
      
      val count = layer * 4 + 1
      val percent = primes.toFloat / count
      println(primes, count, percent)
      
      if (percent < 0.1) {
        return layer * 2 + 1
      }
    }
    0
  }

  def testFind {

    println("answer", find(0.1))
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

It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.

If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?
*/