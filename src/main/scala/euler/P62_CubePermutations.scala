package euler

import junit.framework._

class P62 extends TestCase {
  import Assert._
  import math.Fraction
  
  def cube(n: Long) = {
    n*n*n
  }
  
  def cubeRoot(n: Long): Long = {
    assert(0 <= n)
//    if (n < 3 || n > 9223358842721533951L)
//      return -1
      
    var max = 2097151 //,9223358842721533951
    var min = 0
    var c = 0L
    
    while (max - min > 1) {
      val guess = (max + min) / 2
      c = cube(guess)
      
      if (c < n) {
        min = guess
      } else if (c > n) {
        max = guess
      } else {
        return guess
      }
    }
    
    -1
  }
  
  cube(345)
  cubeRoot(41063625)
  
  def permu(n: Long) = {
    n.toString.permutations.count(p => p(0) != '0' && cubeRoot(p.toLong) > 0)
  }

  permu(cube(100))
  permu(41063625)
  
  def find(d: Int) = {
    val r = (1 to 2097151).find(n => {if (n % 1000 == 0) println(n); permu(cube(n)) == d})
    println("result", d, r, cube(r.get))
    r.get
  }

  def find2(d: Int, less: Fraction) = {
  }

  def testRoot {
    assertEquals(2, cubeRoot(8))
    assertEquals(-1, cubeRoot(9))
    assertEquals(345, cubeRoot(41063625))
  }
  
  def testFind {
    val g = (1 to 20000).takeWhile(n => {val c = cube(n); /*println(n, c)*/; c > 0}).map(cube(_)).groupBy(_.toString.sortWith(_>_))
    
    g("41063625".sorted.reverse)
    g.filter(_._2.size == 3)
    
    {
      val r = g.filter(_._2.size == 3)
      println("result3", r)
    }
    
    {
      val r = g.filter(_._2.size == 4)
      println("result3", r)
    }
    
    {
      val r = g.filter(_._2.size == 5)
      println("result5",r.size, r)
    }
//    assertEquals(345, find(3))
//    assertEquals(41063625, find(5))
  }

}
/*
The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (3843) and 66430125 (4053). In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.

Find the smallest cube for which exactly five permutations of its digits are cube.
*/