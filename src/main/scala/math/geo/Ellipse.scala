package math.geo

/**
 * x^2/a^2 + y^2/b^2 = 1
 */
case class Ellipse(a: Double, b: Double) {
  def m_slope_at(x: Double, y: Double) = {
    -(b/a) * x / y
  }

  def intersect(line: Line) = {
//    assert(this.m - that.m != 0)
    val a = (this.b/this.a + line.m*line.m)
    val b = 2*line.m*line.c
    val c = line.c*line.c - this.b
    
    val (x0, x1) = math.Quadratic.solve(a,b,c)
    

    (Point(x0, line.y(x0)), Point(x1, line.y(x1)))
  }
}