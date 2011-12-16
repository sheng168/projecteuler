package euler

/**
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

    d2d3d4=406 is divisible by 2
    d3d4d5=063 is divisible by 3
    d4d5d6=635 is divisible by 5
    d5d6d7=357 is divisible by 7
    d6d7d8=572 is divisible by 11
    d7d8d9=728 is divisible by 13
    d8d9d10=289 is divisible by 17

Find the sum of all 0 to 9 pandigital numbers with this property.

 */
object P43_Pandigital {
  def divisible(a: Array[Int]) = {
    def sub(a: Array[Int], i:Int) = {
      a(i) * 100 + a(i+1) * 10 + a(i+2)
    }
    
    sub(a, 1) % 2 == 0 &&
    sub(a, 2) % 3 == 0 &&
    sub(a, 3) % 5 == 0 &&
    sub(a, 4) % 7 == 0 &&
    sub(a, 5) % 11 == 0 &&
    sub(a, 6) % 13 == 0 &&
    sub(a, 7) % 17 == 0
  }
  
  def main(args: Array[String]): Unit = {
    val r = (0 to 9).toArray.permutations.filter(divisible).map(_.mkString).map(_.toLong).toList
    
    println(r.sum == 16695334890L)
  }

}