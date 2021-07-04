class Franc(amount: Int, currency: String): Money(amount, currency) {

    fun times(multiplier: Int): Int{
        return amount * multiplier
    }

//    override fun currency(): String
//    {
//        return "CHF"
//    }
}