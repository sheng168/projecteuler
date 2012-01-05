package math

import junit.framework.TestCase
import math.RomanNum._

class RomainNumTest extends TestCase {
  def testParse {
    assert(parse("VVIIIIII") == 16)
  }
}