open class Money(val amount: Int, val currency: String) {

    fun equals(obj: Money): Boolean
    {
        val money: Money = obj
        return amount == money.amount
    }

    open fun currency() : String
    {
        return currency
    }

    companion object Factory{
        fun dollar(amount: Int, currency: String): Dollar{
            return Dollar(amount, currency)
        }
        fun franc(amount: Int, currency: String): Franc{
            return Franc(amount, currency)
        }
    }
}