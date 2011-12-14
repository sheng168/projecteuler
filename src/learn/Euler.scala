package learn

import collection.mutable.ArrayBuffer

// val n = 10
object Prime {
    var primes = ArrayBuffer(2L, 3)
    
    def first(n: Int): Seq[Long] = {
        var next = primes.max + 2
        
        while (primes.length < n) {
            if (!primes.
                //view.filter(_<=math.sqrt(next)).
                exists(next%_==0))
                
              primes += next
            
            next += 2
        }
        
        primes
    }
}

object Euler {
  def time(f : () => Any) = f()
  
  def main(args: Array[String]): Unit = {
    val i = List(1,2,3).view.filter(_<3).find(_==2)
    println(i)
    val s = System.currentTimeMillis()
    println(Prime.first(20001).last)
    println(System.currentTimeMillis() - s)
  }

}