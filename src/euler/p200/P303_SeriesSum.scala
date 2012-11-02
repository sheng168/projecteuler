package euler

object P303 {
  def test(n: Long): Boolean = {
    var t = n
    while (t > 0) {
      if (t % 10 > 2)
        return false
        
      t /= 10
    }
    true
  }
  
  test(210)
  test(321)

  def f(n: Long): Long = {
    println(n)
    for (i <- 1L to Int.MaxValue) {
      if (test(i*n))
        return i*n
    }
    throw new RuntimeException("non found")
  }
  
  def f_(n: Long): Long = {
    println(n)
    var i = 1L
    while (i < Long.MaxValue) {
      if (test(i*n))
        return i
      i += 1
    }
    throw new RuntimeException("non found")
  }

  f_(89)
  
  def sum_f(n: Long) = {
    (1L to n).par.map(n => f_(n)).sum
  }
  
  def sum_f_(n: Long): Long = {
    var set = (1L to n).toList
    var sum = 0L
    
    for (i <- 1 until Int.MaxValue) {
      val s = java.lang.Long.toString(i, 3)
      
      if (s.size < 20) {
          val n012 = s.toLong
	//      println(n012)
	      val (t,f) = set.partition(n012 % _ == 0)
	      if (t.size > 0) {
	        set = f
	        
	        sum += t.map(n012 / _).sum
	        println(f.size, sum, n012, t, f)
	        
	        if (f.size == 0) {
	          return sum
	        }
	      } else if (i % 1000000 == 0) {
	        println(i, n012, n012.toString.size, set)
	      }

      } else {
          val n012 = BigInt(s)
	//      println(n012)
	      val (t,f) = set.partition(n012 % _ == 0)
	      if (t.size > 0) {
	        set = f
	        
	        sum += t.map(a => (n012 / a).toLong).sum
	        println(f.size, sum, n012, t, f)
	        
	        if (f.size == 0) {
	          return sum
	        }
	      } else if (i % 1000000 == 0) {
	        println(i, n012, n012.toString.size, set)
	      }

      }
    }
    0
  }
  
  def main(args: Array[String]): Unit = {
//    (0 to Int.MaxValue-1).view.map(
//    java.lang.Long.toString(_, 3).toLong
//    )
    
    Array(10, 100, 1000, 10000).foreach(i => println(i, sum_f_(i)))
  }

}

/* 2295538033


For a positive integer n, define f(n) as the least positive multiple of n that, written in base 10, uses only digits ≤ 2.

Thus f(2)=2, f(3)=12, f(7)=21, f(42)=210, f(89)=1121222.

Also, .

Find .
*/