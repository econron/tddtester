class Franc(amount: Int): Money(amount) {

    fun times(multiplier: Int): Int{
        return amount * multiplier
    }

}