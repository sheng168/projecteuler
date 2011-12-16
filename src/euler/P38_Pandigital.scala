package euler
import euler.P32_Pandigital

/*
 * Take the number 192 and multiply it by each of 1, 2, and 3:

    192 × 1 = 192
    192 × 2 = 384
    192 × 3 = 576

By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n
 */
object P38_Pandigital {
  val sorted = "123456789"
  val maxInt = sorted.reverse.toInt
  
  def pandigital(n: Int) = {
    if (n > maxInt)
      false
    else
      sorted.startsWith(n.toString.sortWith(_<_))
  }
  
  def cat_pan(a: Int, b: Int, c: Int) = {
    len(a) + len(b) + len(c) == 9 && pandigital((a.toString()+b.toString()+c.toString()).toInt)
  }
  
  def len(n: Int) = {
    var d = 0
    var t = n
    while (t > 0) {
      d += 1
      t /= 10
    }
    d
  }
  
  /**
   * n * (1,2,...n)
   */
  def makeCatProduct(n: Int) = {
    var cat = n.toString()
    var i = 2;
    while (cat.size < 9) {
      cat = cat + (n*i)
      i += 1
    }
    cat.toLong
  }
  
  def check(n: Int) = {
    val v = makeCatProduct(n)
    if (v > maxInt)
      0
      else if (pandigital(v.toInt))
    	v.toInt
	      else
	        0
  }
  
  def main(args: Array[String]): Unit = {
    // 932718654
    var high = 0
    for (i <- 9876 to 1 by -1) {
      val c = check(i)
      if (c > high) {
        println(i, c)
        high = c
      }
    }
  }
}