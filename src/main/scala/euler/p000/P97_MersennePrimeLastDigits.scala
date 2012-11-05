package euler.p000

import scala.BigInt.apply

object P97 {

  def main(args: Array[String]): Unit = {
    (1 to 25).foreach(i=>println(i, pow(9,i), BigInt(9).pow(i)))
  }

  def pow(n: Long, p: Int): Long = {
    p match {
      case 0 => 1
      case 1 => n
      case _ => val r = pow(n, p/2); r*r*pow(n,p%2)
    }
  }
  
}