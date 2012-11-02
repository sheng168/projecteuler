package euler

object P47_PrimeFactors {

  def main(args: Array[String]): Unit = {
    val s = 4
    (1 until Int.MaxValue).sliding(s).find(_.forall(factors(_).toSet.size == s))
  }

  def factors(n: Long): List[Long] = {
    val fact = (2L to n / 2).find(n % _ == 0)
    
    if (fact == None)
      List(n)
    else {
      val f = fact.get
      f +: factors(n/f)
    }
  }
  
  factors(644)
}
/*
The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct primes factors. What is the first of these numbers?
*/