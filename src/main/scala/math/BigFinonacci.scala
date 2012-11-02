package math

object BigFinonacci {
  lazy val fib: Stream[BigInt] = Stream.cons(BigInt(0),Stream.cons(BigInt(1), fib.zip(fib.tail).map(p => p._1 + p._2)))
  
  def main(args: Array[String]): Unit = {
    fib.take(100).print
    println
    var n = 0
    fib.takeWhile(p => {println("take", n, p); n+=1; p.toString().length() > 30}).print
  }

}