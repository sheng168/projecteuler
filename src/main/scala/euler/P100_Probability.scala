package euler

import junit.framework._
import junit.framework.Assert.assertEquals
import math.BigFraction
import scala.BigInt.apply
import scala.math.BigInt.int2bigInt
import scala.math.BigInt.long2bigInt

class P100 extends TestCase {
  import Assert._
  
  def pick2Prob(blue: Long, red: Long) = {
    val tot = blue + red
    (BigFraction(blue, tot) * BigFraction(blue-1, tot-1))
  }
  
//  def rr(n: Long) = {
//    r(n).toDouble / (n-1)
//  }
  
  def find_r(min: Long, p: Double): Long = {
//    val target = 0.999999 * min
//    val b_share = 2.4142135629
//    val tot = b_share + 1.0
//    var b = (b_share / tot * target).toLong
//    var d = (1.0 / tot * target).toLong

    var b = 1L
    var d = 1L
//    var b = 337588022L
//    var d = 139833537L
    
    println("finding", min, p)
    println("start", b+d, b, d, b.toDouble/d, new java.util.Date)

    var report = 1L*100*1000
      
    while (true) {
      val t = pick2Prob(b, d)
      val tp = t.toDouble
//      println(b, d, tp)

      val dif = t - BigFraction(1,2)
      val bd = b+d
      if ((bd) % (report) == 0) {
        println("update", b+d, b, d, b.toDouble/d, t, dif.reduce, new java.util.Date, dif.toDouble)
      }
      if (dif.n == BigInt(0)) {
        println("match", b+d, b, d, b.toDouble/d, t, dif.reduce, new java.util.Date, tp)
        
        if (t.reduce == BigFraction(1,2)) {
          println("real")
          if (b+d > min) {
            return b
          }
        }
        b += 1
        d += 1
      } else if (dif.n < BigInt(0)) {
        b += 1
      } else if (dif.n > BigInt(0)) {
        d += 1
      }
    }
    
    b
  }
  
  def testPick {
    assertEquals(BigFraction(1,2), pick2Prob(15,6))
  }
  
//  def testFind1 {
//    assertEquals(3, find_r(1, 0.5))
//  }
//
//  def testFind20 {
//    assertEquals(15, find_r(20, 0.5))
//  }
//  def testFind200 {
//    assertEquals(493, find_r(200, 0.5))
//  }
  def testFind {
    assertEquals(493, find_r(1000L*1000*1000*1000, 0.5))
  }
}
/*(1 to 19).map(n => n*n)

(finding,1000000000000,0.5)
(match,3,1,4)
(match,15,6,21)
(match,85,35,120)
(match,493,204,697)
(match,2871,1189,4060)
(match,16731,6930,23661)
(match,97513,40391,137904)
(match,568345,235416,803761)
(match,3312555,1372105,4684660)
(match,19306983,7997214,27304197)
(match,112529341,46611179,159140520)
(match,151143306,62605607,213748913)
(match,205751699,85225144,290976843)
(match,244365664,101219572,345585236)
(match,298974057,123839109,422813166)
(match,337588022,139833537,477421559)

*/