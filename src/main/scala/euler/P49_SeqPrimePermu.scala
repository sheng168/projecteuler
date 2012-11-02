package euler

object P49_SeqPrimePermu {
  def isPermu(a: Long, b: Long) = a.toString().sortWith(_<_) == b.toString().sortWith(_<_)
  
  def main(args: Array[String]): Unit = {
    for (a <- 1000 to 9999; b = a + 3330; c = b + 3330) {
      if (Prime.isPrime(a) && Prime.isPrime(b) && Prime.isPrime(c)) {
        println(a)
        if (isPermu(a,b)) {
          println(a,b)
          
          if (isPermu(c,b)) {
        	println(a,b,c)
          }
        }
      }
    }
  }

}
/*
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?
*/