class Sum(val augend: Expression, val addend: Expression, override val amount: Int): Expression {

    override fun reduce(bank: Bank, to: String): Money
    {
        val amount: Int = augend.amount + addend.amount
        return Money(amount, to)
    }

}