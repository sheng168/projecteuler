/**
 * 
 */
package euler

import scala.io.Source

/**
 * @author shengyu
 *
 */
object P18 {

  def main(args: Array[String]): Unit = {
//    new java.io.File(".").getAbsoluteFile()
    val graph = Source.fromFile("C:\\Users\\shengyu\\workspace\\Scala\\p67.txt").getLines().map(_.split(" ").map(_.toInt).map(i=>new Node(i,i))).toIndexedSeq
    
    graph.foreach(println)
    
    def link(parent: Node, child: Node) = {
      val sum = parent.sum + child.cost
      if (sum > child.sum) {
        child.sum = sum
        child.parent = parent
      }
    }
    
    for (r <- 1 until graph.length) {
      val pre = graph(r-1)
      val row = graph(r)
      
      for (i <- 0 until row.length) {
        val node = row(i)
        println(i, node)
        val l = i-1
        val r = i
        
        if (l >= 0) {
          val p = pre(l)
          link(p, node)
        }
        
        if (r < pre.length) {
          val p = pre(r)
          link(p, node)
        }
      }
    }
    //graph.foreach(n=>println(n.mkString(",")))
    
    println(graph.last.map(_.sum).max)
  }

}

case class Node(val cost: Int, var sum: Int = 0, var parent: Node = null)