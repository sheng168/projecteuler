package math

object RomanNum {
  val map = Map('I'->1,'V'->5,'X'->10,'L'->50,'C'->100,'D'->500,'M'->1000)
  
  def parse(rn: String) = {
    (rn.map(map):+(0)).sliding(2).toList.map(p => if (p(0) < p(1)) -p(0) else p(0)).sum
  }
  
  def format(n: Int) = {
    var r = n
    var sb = new StringBuilder
    
    while (r >= 1000) {
      sb.append('M')
      r -= 1000
    }
    
    if (r >= 900) {
      sb.append("CM")
      r -= 900
    }
    
    if (r >= 500) {
      sb.append("D")
      r -= 500
    }
    
    if (r >= 400) {
      sb.append("CD")
      r -= 400
    }
    
    while (r >= 100) {
      sb.append('C')
      r -= 100
    }
    
    if (r >= 90) {
      sb.append("XC")
      r -= 90
    }
    
    if (r >= 50) {
      sb.append("L")
      r -= 50
    }
    
    if (r >= 40) {
      sb.append("XL")
      r -= 40
    }
    
    while (r >= 10) {
      sb.append('X')
      r -= 10
    }
    
    if (r >= 9) {
      sb.append("IX")
      r -= 9
    }
    
    if (r >= 5) {
      sb.append("V")
      r -= 5
    }
    
    if (r >= 4) {
      sb.append("IV")
      r -= 4
    }
    
    while (r >= 1) {
      sb.append('I')
      r -= 1
    }
    sb.toString()
  }
  
  (1 to 100).map(format)
  format(1953)
  
  parse("MCML")
  
  def main(args: Array[String]): Unit = {
    import scala.io.Source
    
    println(new java.io.File(".").getAbsolutePath())
    
    val save = Source.fromFile("p89_roman.txt").getLines().map(s => s.length() - format(parse(s)).length()).sum
    
    println(save)
  }

}