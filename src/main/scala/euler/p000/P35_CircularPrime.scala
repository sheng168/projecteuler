package euler

import euler.Prime
import scala.Some.apply

object P35 {
  def rotate[A,C](coll: C, number: Int)(
		  implicit c2i: C => Iterable[A], cbf: collection.generic.CanBuildFrom[C,A,C]
		  ): Option[C] =
  if (coll.hasDefiniteSize) {
    val positions = number % coll.size match {
      case i if i < 0 => i + coll.size
      case i => i
    }
    val builder = cbf()
    builder ++= coll.drop(positions)
    builder ++= coll.take(positions)
    Some(builder.result())
  } else None
  
  rotate("1", 1)
  
  def main(args: Array[String]): Unit = {
    val r = (1 to 1000000).filter(isCirPrime(_)).size
    
    println(r)
  }

  def isCirPrime(n: Int) = {
    if (Prime.isPrime(n)) {
//      println(n)
      val s = n.toString()
      
      (1 until s.length()).forall(r =>Prime.isPrime(rotate(s, r).get.toInt))
    } else {
      false
    }
  }
}

/*
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
*/