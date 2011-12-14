import scala.xml._
import scala.xml.pull._
import scala.io.Source

object Xml {

 
  def main(args: Array[String]) {
    
    val pre = "<hello>"
    val rep = "<world/>"
      
    val i = (0 to Int.MaxValue-10).view.map(i => if (i < pre.length()) pre(i) else rep((i-pre.length())%rep.length())) //.toIterable.flatten.mkString
    val src = Source.fromIterable(i)
    var n = 0;
    val mx = new jmx.LongValue(n, "test:name=count")
    var er = new XMLEventReader(src)
    
    while (er.hasNext) {
	    er.next match {
	      case EvElemStart(_, "world", _, _) => //println("2")
	      case h: EvElemStart => //println(h)
	      case EvElemEnd(_, "world") => //println("3")
	      case EvText("!") => println("4")
	      case EvElemEnd(_, "hello") => println("5")
		}
	    n += 1
    }

	// you get the picture...
	er.stop  // allow thread to be garbage-collected
	//println("6")
  }
}
 
