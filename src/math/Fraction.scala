package math

/**
 * P33
 */
class Fraction(val n:Int, val d:Int) {
  def reduce = {
    val c = gcd(n,d)
    new Fraction(n/c, d/c)
  }
  override def toString = n + "/" + d
  
  private def gcd(x:Int, y:Int): Int = {
    if (x==0) y
    else if (x<0) gcd(-x, y)
    else if (y<0) -gcd(x, -y)
    else gcd(y%x, x)
  }

}