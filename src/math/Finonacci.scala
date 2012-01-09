package math

object Finonacci {
  lazy val fib: Stream[Long] = Stream.cons(0L,Stream.cons(1L, fib.zip(fib.tail).map(p => p._1 + p._2)))
  
  def main(args: Array[String]): Unit = {
    fib.take(15).print
    
    var n = 0
    fib.takeWhile(p => {println("take", n, p); n+=1; p >= 0}).print
  }

}