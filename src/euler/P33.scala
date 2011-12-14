package euler

object P33 {

  def main(args: Array[String]): Unit = {
    
    for (b <- 11 to 99; t <- 10 until b; 
      rat = new math.Fraction(t,b).reduce; 
      if(rat.n < 10 && rat.d < 10);
      t_ = t.toString().map(_.asDigit).toSet - rat.n;
      b_ = b.toString().map(_.asDigit).toSet - rat.d
    ) {
      if (t_.size == 1 && b_.size == 1 && t_ == b_ && t_ != Set(0))
        println(t, b, rat, t_, b_)
    }
  }

}