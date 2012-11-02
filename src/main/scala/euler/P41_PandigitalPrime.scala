package euler

object P41_PandigitalPrime {

  def main(args: Array[String]): Unit = {
    for (n <- 2 to P32_Pandigital.maxInt if P32_Pandigital.pandigital(n) && Prime.isPrime(n))
      println(n)
      
    println("done")
  }

}