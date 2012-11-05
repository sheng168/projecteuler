package euler.p000

import java.util.Calendar._

object P19 {
  def main(args: Array[String]) {
    val c = new java.util.GregorianCalendar()
    c.set(DAY_OF_MONTH, 1)
    
    var n = 0
    for (y<-1901 to 2000; m<-0 to 11) {
      c.set(YEAR, y)
      c.set(MONTH, m)
      
      if (c.get(DAY_OF_WEEK) == SUNDAY) {
        n += 1
        println(c.getTime,n)
      }
    }
  }
}

/*
You are given the following information, but you may prefer to do some research for yourself.

    1 Jan 1900 was a Monday.
    Thirty days has September,
    April, June and November.
    All the rest have thirty-one,
    Saving February alone,
    Which has twenty-eight, rain or shine.
    And on leap years, twenty-nine.
    A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/