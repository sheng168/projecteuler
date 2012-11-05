package euler.p000

object P21 {

  def main(args: Array[String]): Unit = {
    val p = for (i <- 1 until 10000; sum = sumdiv(i); sum2 = sumdiv(sum); if (i == sum2 && i != sum))
      yield List(i, sum)
    
    println(p.flatten.toSet.sum)
  }

  var n = 220
  
  def sumdiv(n: Int) = divisors(n).sum
  
  def divisors(n: Int) = {
    val last: Int = Math.sqrt(n).asInstanceOf[Int]
    val pairs = for (i <- 2 to last; if (n%i==0)) yield Set(i, n/i)
    pairs.flatten :+ 1
  }
}

/*/*
Let d(n) be defined as the sum of proper divisors of n 
(numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair 
and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; 
therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; 
so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
*/*/