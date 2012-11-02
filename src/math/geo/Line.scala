package math.geo

//import math.geo.Point

case class Segment(val a: Point, val b: Point) {
//  assert(a != b)
  
  def this(a: Point, m: Double) = this(a, Point(a.x + 1, a.y + m))
  
  def m = (b.y-a.y)/(b.x-a.x)
  
  def length = {
    val x = a.x - b.x
    val y = a.y - b.y
    Math.sqrt(x*x + y*y)
  }
  
}

case class Line(val m: Double, val c: Double) {
  def this(line: Segment) = this(line.m, line.a.y - line.a.x * line.m)
  
  def intersect(that: Line): Point = {
    assert(this.m - that.m != 0)
    val x = (that.c - this.c)/(this.m - that.m)
    val y = m*x + c
    Point(x, y)
  }
  
  def reflect(beam: Line): Line = {
    val m = Line.reflectSlope(beam.m, this.m)
    new Line(new Segment(this.intersect(beam), m))
  }
  
  def y(x: Double) = m*x + c
//  LineSlopeIntercept(-0.5, 2).intersect(LineSlopeIntercept(1, -1))
  
  
//  LineSlopeIntercept(1, 2).intersect(LineSlopeIntercept(1, -1))
}

object Line {
  import Math._
  
  def reflectSlope(mBeam: Double, mSurface: Double) = {
    val rad = reflectRad(atan(mBeam), atan(mSurface))
    tan(rad)
//    Math.p
  }
  
  def reflectRad(beam: Double, surface: Double) = {
    val normal = surface + scala.math.Pi/2 
    val diff = normal - beam
    normal + diff
  }

  def reflectDeg(beam: Double, surface: Double) = {
    val normal = surface + 90
    val diff = normal - beam
    normal + diff
  }
  
  reflectRad(scala.math.Pi/2, scala.math.Pi/4)
}