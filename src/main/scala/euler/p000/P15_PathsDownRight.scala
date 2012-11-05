package euler.p000

object P15 {

  def main(args: Array[String]): Unit = {
    val size = 21
    val grid = Array.fill(size, size)(1L)
    
    for(x<-1 until size; y<-1 until size) {
      grid(x)(y) = grid(x-1)(y) + grid(x)(y-1)
    }
    
    grid.foreach(a =>println(a.mkString("\t")))
    println(grid(size-1)(size-1))
  }

}