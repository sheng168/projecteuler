package euler

object P23 {

  def main(args: Array[String]): Unit = {
    val a = for (i <- 1 to 28123; sum = divisors(i).sum; if (sum > i)) yield i
    val abundant = a.toArray
    
    println((1 to 28123).filter(! isSum(_, abundant)).sum)
  }

  def isSum(n: Int, sort: Array[Int]): Boolean = {
    var a = 0
    var b = sort.size - 1
    
    while (a<=b) {
      val sum = sort(a) + sort(b) 
      if (sum== n)
        return true
      else if (sum < n)
        a+=1
      else
        b-=1
    }
    
    false
  }
  
  def isSum_(n: Int, sort: Array[Int]): Boolean = {
    for (a <- sort; b <- sort) {
      if (a+b == n)
        return true
    }
    false
  }

}

/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

*/