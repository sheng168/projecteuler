package math

/**
 * P33, 65
 */

object Fraction {
  def gcd(x:Long, y:Long): Long = {
    if (x==0) y
    else if (x<0) gcd(-x, y)
    else if (y<0) -gcd(x, -y)
    else gcd(y%x, x)
  }
}

case class Fraction(val n:Long, val d:Long = 1) {
//  def this(n: Long) {
//    this(n, 1)
//  }
  
  def reduce = {
    val c = gcd(n,d)
    new Fraction(n/c, d/c)
  }
  
  override def toString = n + "/" + d
  
  private def gcd(x:Long, y:Long): Long = {
    if (x==0) y
    else if (x<0) gcd(-x, y)
    else if (y<0) -gcd(x, -y)
    else gcd(y%x, x)
  }

  def +(that:Fraction) = Fraction(this.n*that.d  + that.n*this.d, this.d * that.d)
  def -(that:Fraction) = Fraction(this.n*that.d  - that.n*this.d, this.d * that.d)
  def *(that:Fraction) = Fraction(this.n * that.n, this.d * that.d)
  def /(that:Fraction) = Fraction(this.n * that.d, this.d * that.n)
  
  def toDouble = n.toDouble / d

  implicit def Long2Frac(n:Long) = Fraction(n)
  /*
  def e(n: Long) = {
    if (n % 3 == 0) {
      n / 3 * 2
    } else {
      1L
    }
  }
  
  (1L to 10).map(e)
  
  var f = Fraction(0)
  for (i <- 10 to 2 by -1; d = e(i)) {
    f = f + Fraction(d)
    f = 1 / f
    println(i, d, f)
  }
  println(2 + f)
  */
}


// Fraction(1,3) + Fraction(2,2)
