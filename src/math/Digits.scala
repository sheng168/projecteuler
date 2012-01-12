package math

object Digits {
  def reverse(n: Int) = {
    assert(n >= 0, n)
    var tmp = n
    var rev = 0
    
    while (tmp > 0) {
      val last = tmp % 10
      tmp = tmp / 10
      rev = rev * 10 + last
    }
    
    rev
  }
  reverse(123)
  reverse(210)
  
  def forall(n: Int, f: Int => Boolean) = {
    assert(n >= 0)
    var tmp = n
    
    var b = true
    while (tmp > 0 && b) {
      val last = tmp % 10
      tmp = tmp / 10
      
      b = f(last)
    }
    b
  }
  forall(135, _ % 2 == 1)
  forall(1235, _ % 2 == 1)
}