open class Money(val amount: Int) {

    fun equals(obj: Money): Boolean
    {
        val money: Money = obj
        // ７章のソースは臭いが、getClassをうまく表現できないものだろうか？
        // もしくはkotlinぽくgetClassを汚く書けないだろうか？後回し。
        return amount == money.amount
    }
}