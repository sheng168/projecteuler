package object euler {
  def divisors(n: Int) = {
    (for (i <- 1 to Math.sqrt(n).toInt; if(n%i==0))
      yield if (i==1 || i*i == n) List(i) else List(i, n/i)).flatten
  }
  
  divisors(4)
}