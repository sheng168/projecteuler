import annotation.tailrec

def length(n: Long): Long = {
    @tailrec def len(n: Long, plus: Long): Long = {
        require(n>=0, "n must to positive: " + n)
            //println(n)
        if (n == 1)
            1 + plus
        else if (n % 2 == 0)
            len(n/2, plus + 1)
        else
            len(3*n + 1, plus + 1)
    }
    
    val r = len(n, 0)
    if (n%1==0)println(n, r)
    r
}

//length(13)
val start = new java.util.Date

val r = (1 to 1000000).toList.par.map(n=>{(n,length(n))}).reduce((a,b)=>{if (a._2 < b._2) {println("big", b); b} else a})
println(new java.util.Date, r)

println(System.currentTimeMillis - start.getTime)
//(1,2)._0