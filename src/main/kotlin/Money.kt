open class Money(val amount: Int) {

    fun equals(obj: Money): Boolean
    {
        val money: Money = obj
        return amount == money.amount
    }
}