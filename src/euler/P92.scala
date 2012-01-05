package euler

object P92 {

  def main(args: Array[String]): Unit = {}
  def next(n: Long) = n.toString().map(_.asDigit.toLong).map(n => n*n).sum
  def chain(n: Long) = {
    var l = n
    var steps = 0
    while (l != 1 && l != 89) {
      l = next(l)
      steps += 1
    }
    (l, steps)
  }
  
  val size = 1000*10000
   
  val one = (1L until size).map(chain).filter(_._1 == 1)
  val _89 = size - 1 - one.size
  println(_89)
}
/*
A number chain is created by continuously adding the square of the digits in a number to form a new number until it has been seen before.

For example,

44 → 32 → 13 → 10 → 1 → 1
85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89

Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.

How many starting numbers below ten million will arrive at 89?
*/