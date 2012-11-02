package euler

import junit.framework._
import math.BigFraction

class P55 extends TestCase {
  import Assert._
  
  def revAdd(n: BigInt) = {
    val r = n + BigInt(n.toString.reverse)
    assert(n < r, "n < r " + n + "<" + r)
    r
  }
  
  def palindrome(n: BigInt) = {
    val s = n.toString()
    s == s.reverse
  }
  
  def isLychrel(b: BigInt) = {
    import scala.annotation.tailrec
    @tailrec def recur(n: BigInt, tries: Int): Boolean = {
      if (palindrome(n)) {
        //println(b, n, tries)
        false
      } else if (tries > 0) {
        recur(revAdd(n), tries - 1)
      } else {
       // println(b, n, tries, false)
        true
      }
    }

    val max = 49
    recur(revAdd(b), max)
  }

  def test47 {
    assertEquals(BigInt(121), revAdd(47))
  }

  def testLychrel47 {
    assertEquals(false, isLychrel(47))
  }
 
  def testLychrel196 {
    assertEquals(true, isLychrel(196))
  }

  def testLychrel4994 {
    assertEquals(true, isLychrel(4994))
  }
  
  def testLychrel10677 {
    assertEquals(true, isLychrel(10677))
  }

  def testFind {
//    assertEquals(142857, (1 until Int.MaxValue).find(isPermu(_, 5)).get)
//    (1 until 100).map(isLychrel(_)).foreach(println)
    
    var greater = 0
    var less = 0
    for (n <- 1 until 10000) {
      val ncr = isLychrel(n)

      if (ncr) {
        greater += 1
      } else {
        less += 1
      }
    }
    
    println(greater, less)
    println("answer", greater)
  }

}
/*
If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.

Not all numbers produce palindromes so quickly. For example,

349 + 943 = 1292,
1292 + 2921 = 4213
4213 + 3124 = 7337

That is, 349 took three iterations to arrive at a palindrome.

Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome. A number that never forms a palindrome through the reverse and add process is called a Lychrel number. Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that a number is Lychrel until proven otherwise. In addition you are given that for every number below ten-thousand, it will either (i) become a palindrome in less than fifty iterations, or, (ii) no one, with all the computing power that exists, has managed so far to map it to a palindrome. In fact, 10677 is the first number to be shown to require over fifty iterations before producing a palindrome: 4668731596684224866951378664 (53 iterations, 28-digits).

Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.

How many Lychrel numbers are there below ten-thousand?

NOTE: Wording was modified slightly on 24 April 2007 to emphasise the theoretical nature of Lychrel numbers.
*/