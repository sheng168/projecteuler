for (c <- 1 to 1000; b <- 1 to c-1; a <- 1 to b-1)
    if (a*a+b*b==c*c && a+b+c==1000)
        println("a",a,b,c, a*b*c)
