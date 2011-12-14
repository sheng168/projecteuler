package euler

import collection.mutable.Map

object P26 {

  def main(args: Array[String]): Unit = {
    for (i <- 1 until 100) {
      println(1.0/i, i)
      repeat(1, i)
    }
    
    (1 until 1000).map(i=>(repeat(1, i),i)).filter(_._1 == 982)
  }

  def repeat(den: Int, div: Int): Int = {
    var count = 0
    var n = den
    
    print(" 0.")
    val remain = Map[Int, Int]()
    
    while (n != 0 && count < 1000) {
      while (n < div) {
        n *= 10
        count+=1
      }
      if (remain.contains(n)) {
        val rep = count - remain(n)
        println("_" + rep)
        return rep
      } else {
        remain(n) = count
      }
      
      print(n / div)
      n = n % div
    }
    println()
    count
  }
}

/*
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

    1/2	= 	0.5
    1/3	= 	0.(3)
    1/4	= 	0.25
    1/5	= 	0.2
    1/6	= 	0.1(6)
    1/7	= 	0.(142857)
    1/8	= 	0.125
    1/9	= 	0.(1)
    1/10	= 	0.1

Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
*/