class Dollar(amount: Int) : Money(amount) {

    fun times(multiplier: Int): Int{
        return amount * multiplier
    }

}