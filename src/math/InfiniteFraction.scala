package math

object InfiniteFraction {
  
  def series(d: Int, n: Int, p: BigFraction => Any) = {
    var f = BigFraction(0)
    
    for (i <- 1 to n) {
      f = f + BigFraction(d)
      f = BigFraction(1) / f
      
      p(f)
//      println(i, d, f)
    }
  
    val v = BigFraction(1) + f
    v
  }

}