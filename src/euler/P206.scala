package euler

object P206 {
  val min = 1020304050607080900L
  val max = 1929394959697989990L
  
  def test(n: Long): Boolean = {
    if (n % 10 != 0)
      return false
      
//    true
//    var d = 9
    var t = n
    for (i <- 9 to 1 by -1) {
      t /= 100
      if (t % 10 != i)
        return false
    }
    true
  }
  
  test(min)
  
  def main(args: Array[String]): Unit = {
    val s = Math.sqrt(min).toLong / 10 * 10
    val e = (Math.sqrt(max).toLong + 1) / 10 * 10
    
    println(s,e,e-s)
    Long.MaxValue.toString().size
    
    for (n <- e to s by -10) {
      val sq = n * n
      if (test(sq)) {
        println(n, sq)
        return
      }
    }
    
    (for (pre <- 0 to 9000 by 1000; post <- List(30))
      yield (pre+post)).map(i => (i,i*i))
  }

}

/*
Find the unique positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0,
where each Ò_Ó is a single digit.
*/