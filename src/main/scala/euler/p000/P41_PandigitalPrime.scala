package euler.p000

import euler.Prime
import euler.p000.P32_Pandigital

object P41_PandigitalPrime {

  def main(args: Array[String]): Unit = {
    for (n <- 2 to P32_Pandigital.maxInt if P32_Pandigital.pandigital(n) && Prime.isPrime(n))
      println(n)
      
    println("done")
  }

}