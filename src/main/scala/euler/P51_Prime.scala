package euler

import junit.framework._
import math.BigFraction

class P51 extends TestCase {
  import Assert._
  
  def isSet(n: Int, pos: Int) = ((n & 1 << (pos)) != 0)

  /*
   * @return 1 to 10
   */
  def prime_fam(p: Long) = {
    val digits = p.toString().map(_.asDigit)
    val size = digits.size
    val max = 1 << size
    var result = 0
    for (mask <- 1 until max) {
      var primes = 0
      var small = Int.MaxValue
      for (rep <- 0 to 9) {
          var n = 0
	      
	      for (pos <- 0 until size) {
	        val dig =
	        if (isSet(mask, size - pos - 1)) {
	          rep
	        } else {
	          digits(pos)
	        }
	        n = n*10 + dig
	      }
	      if (Prime.isPrime(n) && n.toString().size == size) {
	        println(mask, Integer.toBinaryString(mask), n)
	        primes += 1
	        if (small > n) {
	          small = n
	        }
	      }
      }
      if (result < primes) {
        result = primes
        println("result", result, mask, Integer.toBinaryString(mask), p, small)
      }
    }
    result
  }
  
  def find_prime_fam(size: Int) = {
    (120000 until Int.MaxValue).find(n => Prime.isPrime(n) && prime_fam(n) >= size).get
  }

  // tests
  def test13 {
    assertEquals(6, prime_fam(13))
  }
  def test56003 {
    assertEquals(7, prime_fam(56003))
  }
  
  // test find
//  def testFind5 {
//    assertEquals(13, find_prime_fam(6))
//  }
//  def testFind7 {
//    assertEquals(56003, find_prime_fam(7))
//  }
  def testFind8 {
    assertEquals(121313, find_prime_fam(8))
  }
}
/*
By replacing the 1st digit of *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
*/