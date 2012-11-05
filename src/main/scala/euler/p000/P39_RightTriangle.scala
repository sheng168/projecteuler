package euler.p000

import scala.Some.apply

object P39 {

  def main(args: Array[String]): Unit = {
    var p = 1000
    var sum = 0
    val sqrts = 
      for (a <- 1 to p/2; b <- a to p/2; s = sqrt(a*a + b*b); if (s!= None); h = s.get) 
    	yield (a,b,h,a+b+h)
    	
    sqrts.groupBy(_._4).foreach(println)
//{
//      val s = sqrt(a*a + b*b) 
//      if (s!= None) {
//    	val h = s.get
//    	
//    	println(a,b,h,a+b+h)
//    	yield (a,b,h,a+b+h)
//      }
//      yield (a,b,h,a+b+h)
//    }
  }

  def sqrt(n: Long): Option[Long] = {
    val sqrt_double = Math.sqrt(n)
    val sqrt = sqrt_double.toLong
    
    if (sqrt*sqrt == n) {
      Some(sqrt)
    } else {
      None
    }
  }
}
/*

, there are exactly three solutions for p = 120.


{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ? 1000, is the number of solutions maximised?
*/