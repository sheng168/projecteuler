package euler

object P29 {
  def main(args: Array[String]) {
    val terms = collection.mutable.Set[BigInt]()
    val m = 100
    for (a <- 2 to m; b <- 2 to m) {
      terms += BigInt(a).pow(b)
    }
    
    val n = m - 1
    println(n*n,terms.size)
    BigInt(100).pow(100)
  }
}