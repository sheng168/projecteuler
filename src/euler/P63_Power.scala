package euler

import junit.framework._

class P63 extends TestCase {
  import Assert._
  
  def spirl(layer: Int) = {
    (1 to 1000).find(p => {val len = BigInt(2).pow(p).toString.size; println(len, p); len > p})
  }
  
  def find(ratio: Double): Int = {
    var dia = 1
    var primes = 0
    for (base <- 1 to 9) {
      for (exp <- 1 to 52) {
        val n = BigInt(base).pow(exp)
        
        if (n.toString.size == exp) {
          primes +=1
          println(base, exp, n)
        }
      }
      
      println(primes, base)
    }
    0
  }

  def testFind {

    println("answer", find(0.1))
  }

}
/*
The 5-digit number, 16807=75, is also a fifth power. Similarly, the 9-digit number, 134217728=89, is a ninth power.

How many n-digit positive integers exist which are also an nth power?
*/