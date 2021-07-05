open class Money(val amount: Int, val currency: String): Expression {

    fun equals(obj: Money): Boolean
    {
        val money: Money = obj
        return amount == money.amount
    }

    open fun currency(): String
    {
        return currency
    }

    fun times(multiplier: Int): Int
    {
        return amount * multiplier
    }

    // chapter12: 複数の通貨を扱っていることをほとんど意識させないようにしたい　という制約
    fun plus(addend: Money): Money
    {
        return Money(addend.amount, currency)
    }

    companion object Factory{
        fun dollar(amount: Int, currency: String): Money{
            return Money(amount, currency)
        }
        fun franc(amount: Int, currency: String): Money{
            return Money(amount, currency)
        }
    }
}