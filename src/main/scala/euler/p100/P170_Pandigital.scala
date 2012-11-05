package euler.p100

/*
 * Take the number 6 and multiply it by each of 1273 and 9854:

6 × 1273 = 7638
6 × 9854 = 59124

By concatenating these products we get the 1 to 9 pandigital 763859124. We will call 763859124 the "concatenated product of 6 and (1273,9854)". Notice too, that the concatenation of the input numbers, 612739854, is also 1 to 9 pandigital.

The same can be done for 0 to 9 pandigital numbers.

What is the largest 0 to 9 pandigital 10-digit concatenated product of an integer with two or more other integers, such that the concatenation of the input numbers is also a 0 to 9 pandigital 10-digit number?

 */
object P170_Pandigital {
  val sorted = "0123456789"
  val maxInt = sorted.reverse.toLong
  
  def pandigital(n: Int) = {
    if (n > maxInt)
      false
    else
      pandig(n)
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
  
  def divisible(a: Array[Int]) = {
    def sub(a: Array[Int], i:Int) = {
      a(i) * 100 + a(i+1) * 10 + a(i+2)
    }
    
    var n = 5
    var prefix = 0
    var remain = a.takeWhile(i => {
      prefix *= 10
      prefix += i
      prefix % n != 0
    })
    
    println(prefix, remain.mkString)
    prefix % n == 0
  }
    divisible((1 to 9).toArray)

  def splitDiv(a: Array[Int], div:Int): Option[Array[Int]] = {
    var prefix = 0
    var r = collection.mutable.ArrayBuffer[Int]()
    
    a.foreach(d => {
      prefix *= 10
      prefix += d
      if (prefix % div == 0) {
//        println(prefix)
        r += prefix
        prefix = 0
      }
    })
    
    if (prefix % div == 0)
      Some(r.toArray)
      else
    	  None
  }
  
  splitDiv((9 to 0 by -1).toArray, 4)
  
  def pandig_div(a: Array[Int], div:Int): Boolean = {
    val str = a.map(_/div).mkString + div
    
//    println(str)
    pandig(str)
  }
  
  
  def main(args: Array[String]): Unit = {
    var min: Long = 123456789
    
    for (i <- 3 to 100) {
	    val r = (9 to 0 by -1).toArray.permutations.map(a => (a, splitDiv(a, i)))
	    		.find(t => t._1.mkString.toLong <= min || t._2 != None && pandig_div(t._2.get, i))
	//    val s = r.take(5).toList
	    val n = r.get._1.mkString.toLong
	    
	    if (n > min) {
	      min = n
	    }
	    println(i, min, r, r.get._2.map(_.toList))
	//    s(0).get.mkString(",") 
    }

    return
    
    for (i <- 101 to 1000) {
	    val r = (9 to 0 by -1).toArray.permutations.map(a => splitDiv(a, i)).filter(_ != None).filter(op => pandig_div(op.get, i))
	//    val s = r.take(5).toList
	    println(i, r.toList)
	//    s(0).get.mkString(",") 
    }
  }
  
  private def pandig(n: Int): Boolean = {
    sorted.startsWith(n.toString.sortWith(_<_))
  }

  private def pandig(n: String): Boolean = {
    sorted.startsWith(n.sortWith(_<_))
  }
}