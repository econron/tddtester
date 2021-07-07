interface Expression {
    fun reduce(to: String): Money
    {
        return Money.money(1, "any")
    }
}