class Bank {

    val rates = hashMapOf<Pair, Int>()

    fun reduce(source: Expression, to: String): Money
    {
        return source.reduce(this, to)
    }

    fun addRate(from: String, to: String, rate: Int)
    {
        rates[Pair(from, to)] = rate
    }

    fun rate(from: String, to: String): Int?
    {
        if(from == to) return 1
        return rates[Pair(from, to)]
    }
}