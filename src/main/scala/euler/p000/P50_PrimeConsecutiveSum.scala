package euler

import euler.Prime.isPrime
import euler.Time
import scala.collection.immutable.List.apply

object P50 {
  def main(args: Array[String]) {
    import euler.Prime._
    
    
    List(100, 1000, 1000*10, 1000*100, 1000*1000, 1000*10000).foreach(t(_))
  }

  def t(max: Int) {
    Time.time(pcs(max))
  }
  
  def pcs(max: Int) {
    import euler.Prime._
    
    val pa = (1 to max).filter(isPrime(_)).toArray
    val pset = pa.toSet
    
    var count = 0
    var sum = 0
    pa.takeWhile(n => {count+=1; sum+=n; sum < max})
    println("pcs", count, max)
    
    for (s <- count to 1 by -1) {
      println(s)
      val op = pa.sliding(s).find(w => {val sum = w.sum; sum <= max && isPrime(sum)})
      if (op != None) {
        val r = op.get.toList
        println(r.sum, r.size, pa.size, r)
        return
      }
    }
  }
}
/*
The prime 41, can be written as the sum of six consecutive primes:
41 = 2 + 3 + 5 + 7 + 11 + 13

This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
*/