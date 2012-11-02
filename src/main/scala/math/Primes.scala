package math

object Primes {
  def from(n: Int): Stream[Int] =
    Stream.cons(n, from(n + 1))

  def sieve(s: Stream[Int]): Stream[Int] =
    Stream.cons(s.head, sieve(s.tail filter { _ % s.head != 0 }))

  def primes = sieve(from(2))

  primes take 10 print

  def main(args: Array[String]) {
	primes.takeWhile(p => {println(p); true}).sum
	// runs out of memory after prime 20327
  }
}