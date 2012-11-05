package euler.p100

import junit.framework._

class P145 extends TestCase {
  import Assert._
  import math.Digits._
    
  
  def find(d: Int, start: Int = 1) = {
    assert(start < d)
    var i = start
    var c = 0
    while (i < d) {
      if (i % 10 != 0 && math.Digits.forall(i + reverse(i), _ % 2 == 1)) {
        c +=1
      }
      i += 1
    }
//    println("rev", d, c)
    c
  }
  
  def find_for(d: Int) = {
//    var i = 1
    var c = 0
    for (i <- 1 until d) {
      if (i % 10 != 0 && math.Digits.forall(i + reverse(i), _ % 2 == 1)) {
        c +=1
      }
//      i += 1
    }
    println("rev", d, c)
    c
  }

  def find_func(d: Int) = {
    val c = (1 until d).count(i => i % 10 != 0 && math.Digits.forall(i + reverse(i), _ % 2 == 1))    
    println("rev", d, c)
    c
  }
  
  def find_concur(d: Int) = {
    val slice = 1000000
    val c = (1 to d/slice).par.map(i => {val end = i*slice; find(end, end-slice)}).sum
    println("concur", d, c)
    c
  }


  def testFind {
//    assertEquals(120, find_concur(1000))
    List(/*1, 10, 100,1000,*/1000000).map(_*1000).foreach(find_concur(_))
//    assertEquals(608720, find_concur(5))
  }

}
/*
The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (3843) and 66430125 (4053). In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.

Find the smallest cube for which exactly five permutations of its digits are cube.
*/