class Dollar(val amount: Int) {
    fun times(multiplier: Int): Int{
        return amount * multiplier
    }

    // for first commit
    fun equals(obj: Dollar): Boolean
    {
        val amount = amount
        return amount == obj.amount
    }

}