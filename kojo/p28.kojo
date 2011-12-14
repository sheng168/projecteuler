def spirl(n: Int) = {
    val sqrt: Int = n/2
    var c = 1
    
    for (i <- 1 to sqrt; _ <- 1 to 4) yield {
        c += (i*2)
        //println(c)
        c
    }
}

spirl(1001).sum + 1
