package euler

object P31 {

  def main(args: Array[String]): Unit = {
    val t = Array(200, 100, 50, 20, 10, 5, 2, 1)
    
    var p = 200
    var count = 0
    for {
      p200 <- 0 to 1
      a = p - p200*200
      
      p100 <- 0 to (a)/100
      b = a - p100*100
      
      p50  <- 0 to (b)/50
      c = b - p50*50
      
      p20  <- 0 to (c)/20
      d = c - p20*20
      
      p10  <- 0 to (d)/10
      e = d - p10*10
      
      p5  <- 0 to (e)/5
      f = e - p5*5
      
      p2  <- 0 to (f)/2
      g = f - p2*2
      
      p1 = g
    } {
//      println(p200, p100, p50,p20, p10, p1)
      count+=1
    }
    
    println(count)
  }

}

/*
In England the currency is made up of pound, , and pence, p, 
and there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, 1 (100p) and 2 (200p).
It is possible to make 2 in the following way:

11 + 150p + 220p + 15p + 12p + 31p
How many different ways can 2 be made using any number of coins?
*/