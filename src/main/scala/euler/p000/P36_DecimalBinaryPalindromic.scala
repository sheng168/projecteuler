package euler.p000

object P36 {
  def main(args: Array[String]) {
    val m = 1000000
    var r = 0
    r = time((1 until m).par.filter(pal(_)).sum)
    r = time((1 until m).filter(pal(_)).sum)
    
    r = time((1 until m by 2).par.filter(pal(_)).sum)
    r = time((1 until m by 2).filter(pal(_)).sum)
    println(r)
  }
  
  def pal(n: Int) = {
    palDec(n) && palBin(n)
  }

  def palDec(n: Int) = {
    val s = n.toString
    s == s.reverse
  }
  
  def palBin(n: Int) = {
    val s = Integer.toBinaryString(n)
    s == s.reverse
  }
  
  def time[T](code: => T) = {
    val t = System.nanoTime
    val res = code
    println((System.nanoTime()-t)/1.0e6 + "ms taken for " + res)
    res
  }
}