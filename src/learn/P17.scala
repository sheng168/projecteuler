package learn

object P17 {

  def main(args: Array[String]): Unit = {
    "COLIN".map(_ - 'A' + 1).sum
    (1 to 1000).map(i=>words(i)).map(_.filter(c=>c!=' ' && c != '-')).map(_.length()).sum
  }

  val n0_19 = Array("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
      "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
  val n20_90 = Array(
      "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")
  def words99(n: Int): String = {
    require(1 <= n && n <= 99)
    if (n < n0_19.length)
      n0_19(n)
    else {
      val d = n%10
      
      n20_90(n/10-2) + (if (d == 0) "" else ("-" + words99(n%10)))
    }
  }
  
  def words999(n: Int) = {
    require(1 <= n && n <= 999, n)
    
    val _100 = n / 100
    val _1 = n % 100
    
    if (_100 == 0)
      words99(_1)
    else {
      val h = words99(_100) + " hundred"
      if (_1 == 0)
        h
      else
        h + " and " + words99(_1)
    }
  }
  
  def words(n: Int) = {
    require(1 <= n && n <= 1000)
    if (n < 1000)
      words999(n)
    else
      "one thousand"
  }
  
  def countWords(n: Int) = {
    require(1 <= n && n <= 1000)
    var count = 0
    var parts = 0
    var t = n
//    val digits = n.toString().map(_.asDigit).pad
    val _1 = t % 10; t /= 10
    val _10 = t % 10; t /= 10
    val _100 = t % 10; t /= 10
    val _1000 = t % 10; t /= 10

    if (_1000 > 0) count += 2
    if (_100 > 0) count += 2
    if (_10 >= 2) {
      count += 1
      if (_1 > 0) count += 1
    } else if (_10 == 1){
      count += 1
    } else { // 0
      if (_1 > 0) count += 1
    }
    
    count
  }
}