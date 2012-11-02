package euler.p200

import junit.framework._

// Fib
class P144 extends TestCase {
  import Assert._

  import Math._
  
  import math.geo._
  
  Segment(Point(0,0), Point(1,1)).m
  new Segment(Point(0,0), 1.0).m
  
  // line y = m*x + c
  // c = y - m*x
  val start = Point(0, 10.1)
  val contact = Point(1.4, -9.6)
  val ellipse = Ellipse(25, 100) //(4, 1, 100)
  val hole = (-0.01, +0.01)
  
  def slope(x: Double, y: Double) = {
    -4 * x / y
  }

  
  Segment(start, contact).m
  Segment(contact, start).m
  slope(1.4, -9.6)

  def intersect(start: Point, m: Double): Point = {
    // TODO
    println("intersect", start, m)
    
    val (p0, p1) = ellipse.intersect(new Line(new Segment(start, m)))
    
    if (Segment(start, p0).length < Segment(start, p1).length) {
      p1
    } else {
      p0
    }
  }
  
  def times = {
    var count = 0
    
    var p0 = start
    var p1 = contact
    var m = Segment(start, contact).m
    
    while (!(p1.y > 9 && abs(p1.x) < hole._2 )) {
      val tangent = slope(p1.x, p1.y)
      
      m = Line.reflectSlope(m, tangent)
      p0 = p1
      p1 = intersect(p0, m)
      
      count += 1
      
      println("reflect", count, p1)
    }
    
    count
  }
  

  def testFind {
    assertEquals(354, times)
  }
}
/*
In laser physics, a "white cell" is a mirror system that acts as a delay line for the laser beam. The beam enters the cell, bounces around on the mirrors, and eventually works its way back out.

The specific white cell we will be considering is an ellipse with the equation 4x^2 + y^2 = 100

The section corresponding to 0.01  x  +0.01 at the top is missing, allowing the light to enter and exit through the hole.


The light beam in this problem starts at the point (0.0,10.1) just outside the white cell, and the beam first impacts the mirror at (1.4,-9.6).

Each time the laser beam hits the surface of the ellipse, it follows the usual law of reflection "angle of incidence equals angle of reflection." That is, both the incident and reflected beams make the same angle with the normal line at the point of incidence.

In the figure on the left, the red line shows the first two points of contact between the laser beam and the wall of the white cell; the blue line shows the line tangent to the ellipse at the point of incidence of the first bounce.

The slope m of the tangent line at any point (x,y) of the given ellipse is: m = 4x/y

The normal line is perpendicular to this tangent line at the point of incidence.

The animation on the right shows the first 10 reflections of the beam.

How many times does the beam hit the internal surface of the white cell before exiting?
*/