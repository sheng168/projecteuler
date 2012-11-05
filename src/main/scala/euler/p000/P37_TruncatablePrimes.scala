package euler.p000

import euler.Prime

object P37 {

  def main(args: Array[String]): Unit = {
    var count = 0
    var sum = 0
    (11 to Int.MaxValue).foreach(i=>if (tp(i)) {count+=1; sum += i
      println(count, i, sum); if (count==11) return})
  }

  def tp(n: Int) = rtp(n) && ltp(n)
  
  def rtp(n: Int): Boolean = {
//    "123".init
//    println(n)
    if (n > 9)
      Prime.isPrime(n) && rtp(n.toString.init.toInt)
    else
      Prime.isPrime(n)
  }

  def ltp(n: Int): Boolean = {
//    "123".init
//    println(n)
    if (n > 9)
      Prime.isPrime(n) && ltp(n.toString.tail.toInt)
    else
      Prime.isPrime(n)
  }

}

/*
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
*/