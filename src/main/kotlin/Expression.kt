interface Expression {
    val amount: Int
    fun plus(addend: Expression){

    }
    fun reduce(bank: Bank, to: String): Money
    {
        return Money.money(1, "any")
    }
}