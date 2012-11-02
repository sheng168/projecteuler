def factors(n: Int) = {
    val sqrt: Int = Math.sqrt(n).toInt
    var c = 2
    
    for (i <- 2 to sqrt)
        if (n%i==0)
            c += 2
    
    c
}

(1 to 700000).view.map(i=>(1 to i).sum).map(i=>(i,factors(i))).find(_._2>500)