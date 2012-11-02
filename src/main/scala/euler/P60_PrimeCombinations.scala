package euler

import junit.framework._

class P60 extends TestCase {
  import Assert._
  
  def check(list: List[Long]) = {
    list.combinations(2).forall(p => {
      val a = p(0).toString()
      val b = p(1).toString()
      
      Prime.isPrime((a+b).toLong) && Prime.isPrime((b+a).toLong)
    })
  }
  
  def find(n: Int) = { // build combination of primes and check too slow for n = 5
    Prime.fillUpTo(673)
    val primes = Prime.primes.toList
    println(primes.size, primes.combinations(n).size, primes)
    primes.combinations(n).find(check).get
  }
  
  def find2(n: Int) = { // build up find wrong answer for 5
    var list = List("3")
    (1 until Int.MaxValue).filter(p => {
      val r = Prime.isPrime(p) && list.forall(c => Prime.isPrime((c + p).toLong) && Prime.isPrime((p + c).toLong))
      if (p % 100000 == 0) {
        println(p)
      }
      if (r) {
        list = p.toString +: list
        println(list)
        
        if (list.size >= n) {
//          return List(129976621, 673, 109, 7, 3).sum
        }
      }
      r
    })
  }

//  import euler.Prime
  
  def splitable(n: Int) = {
    val set = collection.mutable.Set[(Int,Int)]()
    val s = n.toString()
    (1 until s.size).foreach(p => {
      val (a,b) = s.splitAt(p)
      if (a(0) != '0' && b(0) != '0' && Prime.isPrime(a.toInt) && Prime.isPrime(b.toInt)) {
        set.add((a.toInt,b.toInt))
      }
    })
    set//.map(_.toInt)
  }
  splitable(7109)
  
  def swap(n: Int) = {
    splitable(n).filter(p => Prime.isPrime((p._2.toString + p._1).toInt))
  }
  
  def find3(n: Int) = {
    var primes = 0
    var split = 0
    
    var set = collection.mutable.Set[(Int,Int)]()
    (1 to 673109).filter(p => {
      val r = Prime.isPrime(p)
      
      if (p % 100000 == 0) {
        println(p)
      }
      if (r) {
        primes += 1
        val parts = swap(p)
        
        if (parts.size > 0) {
          split += 1
          
          set ++= parts
          set = set.map(p => (Math.min(p._1, p._2), Math.max(p._1, p._2)))
//                  set. = p.toString +: list
          println(primes, split, p, parts, set.size)

//          return List(129976621, 673, 109, 7, 3).sum
        }
      }
      r
    })
    set.toList.sortBy(_._1).foreach(println)
    set.toList.sortBy(_._2).foreach(println)
    
    val can = set.toList.map(_._1) ++ set.toList.map(_._2)
    
    val canPri = can.groupBy(p => p).filter(p => p._2.size >= 3).toList.map(p => (p._1.toLong, p._2.size)).sortBy(-_._2)
    canPri.combinations(4).size //find(check).get
  }
  
  def testCheck {
    val list = List[Long](3,7,109,673)
    assertEquals(true, check(list))
  }

//  def testCheck2 {
//    val list = List(129976621L, 673, 109, 7, 3)
//    assertEquals(true, check(list))
//  }
  
  def testFind {
    val list = List[Long](3,7,109,673)
    assertEquals(list, find3(4))
  }
  
  def testAnswer {
    val list = List[Long](3,7,109,673)
//    assertEquals(list, find2(5))
  }
}
/*
The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.

Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
*/