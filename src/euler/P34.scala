package euler

object P34 {

  def main(args: Array[String]): Unit = {
    var sum = 0
    (10 to 1000000).foreach(i=>if (i ==sumOfFactOfDigits(i)) {println(i);sum+=i})
    
    println("sum", sum)
  }

  def fact(n: Int) = (1 to n).product
  
  def test(n: Int) = {
    n.toString.map(_.asDigit).map(fact).sum == n
  }
  
  test(145)
  private def sumOfFactOfDigits(n: Int): Int = {
    n.toString.map(_.asDigit).map(fact).sum 
  }
}

/*
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
*/