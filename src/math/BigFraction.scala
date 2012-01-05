package math

/**
 * P33, 65
 */
case class BigFraction(val n:BigInt, val d:BigInt = 1) {
//  def this(n: BigInt) {
//    this(n, 1)
//  }
  
  def reduce = {
    val c = gcd(n,d)
    new BigFraction(n/c, d/c)
  }
  
  override def toString = n + " / " + d
  
  private def gcd(x:BigInt, y:BigInt): BigInt = {
    if (x==0) y
    else if (x<0) gcd(-x, y)
    else if (y<0) -gcd(x, -y)
    else gcd(y%x, x)
  }

  def +(that:BigFraction) = BigFraction(this.n*that.d  + that.n*this.d, this.d * that.d)
  def -(that:BigFraction) = BigFraction(this.n*that.d  - that.n*this.d, this.d * that.d)
  def *(that:BigFraction) = BigFraction(this.n * that.n, this.d * that.d)
  def /(that:BigFraction) = BigFraction(this.n * that.d, this.d * that.n)

  def toDouble = n.toDouble / d.toDouble
  
  implicit def BigInt2Frac(n:BigInt) = BigFraction(n)
  /*
  */
  def e(n: BigInt) = {
    if (n % 3 == 0) {
      n / 3 * 2
    } else {
      BigInt(1)
    }
  }
  /*
  (1L to 10).map(BigInt(_)).map(e)
  
  var f = BigFraction(0)
  for (i <- 100 to 2 by -1; d = e(BigInt(i))) {
    f = f + BigFraction(d)
    f = BigInt(1) / f
    println(i, d, f)
  }
  
  val v = BigInt(2) + f
  println(v)
  println(v.n.toString().map(_.asDigit).sum)
  */
  def next(n: Long) = n.toString().map(_.asDigit.toLong).map(n => n*n).sum
  def chain(n: Long) = {
    var l = n
    var steps = 0
    while (l != 1 && l != 89) {
//      println(l)
      l = next(l)
      steps += 1
    }
    (l, steps)
  }
  
//    val size = 1000*10000 - 1
//   
//  val one = (1L to size).par.map(chain).filter(_._1 == 1)
//  val _89 = size - one.size
//  println(_89)
}



// BigFraction(1,3) + BigFraction(2,2)
