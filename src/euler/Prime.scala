package euler

import collection.mutable.ArrayBuffer

// val n = 10
object Prime {
  var primes = ArrayBuffer(2L, 3)

  def first(n: Int): Seq[Long] = {
    var next = primes.last + 2

    while (primes.length < n) {
      if (!primes.exists(next % _ == 0))
        primes += next

      next += 2
    }

    primes
  }
  
  def fillUpTo(n: Long) {
    var next = primes.last + 2

    while (primes.last < n) {
      if (!primes.exists(next % _ == 0))
        primes += next

      next += 2
    }

    primes
  }
  
  def _isPrime(n: Long) =  ! primes.view.takeWhile(_ <= Math.sqrt(n)).exists(n % _ == 0)
  
  def isPrime(n: Long) = {
    if (n % 2 == 0)
      false
    else if (primes.last >= n)
      primes.contains(n)
    else {
      fillUpTo(Math.sqrt(n).asInstanceOf[Long])
      _isPrime(n)
    }
//      primes.view.takeWhile(_ < Math.sqrt(n)).exists(n % _ != 0)
  }
}
