class Pair(val from: String, val to: String) {

    fun equals(obj: Pair): Boolean
    {
        val pair: Pair = obj
        return pair.from.equals(to) && pair.to.equals(from)
    }

    override fun hashCode(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Pair

        if (from != other.from) return false
        if (to != other.to) return false

        return true
    }
}