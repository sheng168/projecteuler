package euler

object P32_Pandigital {
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
  
  def main(args: Array[String]): Unit = {
    val cap = 10000
    
    val products = for (a <- 1 to cap; b <- a+1 to cap; c = a*b if cat_pan(a,b,c))
//    { //
//      println(a, b, c)
//    } 
    yield c
    
    println(products.sum)
    println(products.toSet.sum)
    
//    var a = 2
//    while (true) {
//      var b = a+1
//      
//      while (true) {
//        
//        b += 1
//      }
//      a += 1
//    }
  }

}