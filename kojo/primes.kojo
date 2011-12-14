import collection.mutable.ArrayBuffer

// val n = 10
object Prime {
    var primes = ArrayBuffer(2L, 3)
    
    def first(n: Int): Seq[Long] = {
        var next = primes.max + 2
        
        while (primes.length < n) {
            if (!primes.exists(next%_==0))
                primes += next
            
            next += 2
        }
        
        primes
    }
}

val p = Prime.first(150001).last
p.length
println(p.max)

Prime.primes.filter(_<2000000).sum