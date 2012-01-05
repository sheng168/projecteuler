package euler

object P40 {

  def main(args: Array[String]): Unit = {
    val sb = new StringBuilder(1000000)
    var i = 0
    while (sb.length < 1000000) {
      i += 1
      sb.append(i)
    }
    
    var p = 1
    i = 1
    while (i <= 1000000) { {
        val d = sb.charAt(i-1).asDigit
        p *= d
        println(i,d, p)
        i *= 10
      }
    }
  }

}

/*
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
*/