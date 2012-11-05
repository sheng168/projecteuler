package euler.p000

import euler.Prime.isPrime

object P46 {
  def main(args: Array[String]) {
    import euler.Prime._
    
    val ex = (3 until Int.MaxValue by 2).view.filter(! isPrime(_)).find(primePlus2Sq(_) == None)
    println(ex)
  }
  
  def primePlus2Sq(n: Int) = {
    import euler.Prime._
    
    val last = Math.sqrt((n - 1) / 2).toInt
    println(n, last)
    (1 to last).find(i => isPrime( n - (i*i)*2 ))
  }
  
  primePlus2Sq(15)
}
/*
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×12
15 = 7 + 2×22
21 = 3 + 2×32
25 = 7 + 2×32
27 = 19 + 2×22
33 = 31 + 2×12

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
*/