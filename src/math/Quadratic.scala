package math

object Quadratic {
  //a x^2 + b x + c = 0 

  def solve(a: Double, b:Double, c:Double) = {
    val sqrt = Math.sqrt(b*b - 4*a*c)
    
    val x0 = (-b + sqrt)/(2*a)
    val x1 = (-b - sqrt)/(2*a)
    
    (x0, x1)
  }
}