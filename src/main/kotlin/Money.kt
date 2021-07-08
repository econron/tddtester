open class Money(override val amount: Int, val currency: String): Expression {

//    fun equals(obj: Money): Boolean
//    {
//        val money: Money = obj
//        return amount == money.amount
//    }

    open fun currency(): String
    {
        return currency
    }

    fun times(multiplier: Int): Expression
    {
        return money(multiplier * amount, currency)
    }

    // chapter12: 複数の通貨を扱っていることをほとんど意識させないようにしたい　という制約
    override fun plus(addend: Expression): Expression {
        return Sum(money(amount, currency), addend)
    }

    override fun reduce(bank: Bank, to: String): Money
    {
        val rate: Int? = bank.rate(currency, to)
        return Money(amount / rate!!, to)
    }

    companion object Factory{
        fun money(amount: Int, currency: String): Money{
            return Money(amount, currency)
        }
        fun dollar(amount: Int, currency: String): Money{
            return Money(amount, currency)
        }
        fun franc(amount: Int, currency: String): Money{
            return Money(amount, currency)
        }
    }
}