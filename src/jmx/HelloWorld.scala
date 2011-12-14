import java.lang.Math;

object HelloWorld {

  def main(args: Array[String]): Unit = {
    println("Hello World!")
    "ahelloworldasdasdasd".par.foreach(println)
    (1 to 100).par foreach println
  }

  def ensure(pred: => Boolean) {
    if (! pred) 
      throw new AssertionError
  }
}

class Time {
  
      private[this] var h = 12
      private[this] var m = 12
  
      def hour: Int = h
      def hour_= (x: Int) {
        require(0 <= x && x < 24)
        h = x
      }
  
      def minute = m
      def minute_= (x: Int) {
        require(0 <= x && x < 60)
        m = x
      }
      
      override def toString = h + ":" + m
    } 

import collection.immutable.HashSet
class Thermometer {
  
	var c: Float = _
	
      (1 to 10).find(i => i*i > 10).get - 1
  
      def f = c * 9 / 5 + 32
      def f_= (f: Float) {
        java.lang.Math.sqrt(10)

        c = (f - 32) * 5 / 9
      }
      override def toString = f +"F/"+ c +"C"
    }

class Cell[T](init: T) {
  private[this] var current = init
  def get = current
  def set(x: T) { current = x }
}



