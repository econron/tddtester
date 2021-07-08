import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MoneyTest {
    @Test
    fun testMultiplication()
    {
        // Explicitly given type is redundant here
        val five: Money = Money.dollar(5, "USD")
        val ten: Money = Money.dollar(10, "USD")
        assertEquals(ten.amount, five.times(2))
        assertEquals(15, five.times(3))
    }

//    @Test
//    fun francMultiplication()
//    {
//        // 現時点でfranとdollarの違いはなし
//        val francFive: Money = Money.franc(5, "CHF")
//        val francTen: Money = Money.franc(10, "USD")
//        assertEquals(francTen.amount, francFive.times(2))
//        assertEquals(15, francFive.times(3))
//    }


    @Test
    fun testEquality()
    {
        assertTrue(Money(5, "USD").equals(Money(5, "USD")))
        assertFalse(Money(5, "USD").equals(Money(6, "USD")))
    }

//    @Test
//    fun testFrancEquality()
//    {
//        assertTrue(Franc(5, "USD").equals(Franc(5, "USD")))
//        assertFalse(Franc(5, "USD").equals(Franc(6, "USD")))
//    }

//    @Test
//    fun testEqualityBetweenDollarAndFranc()
//    {
//        assertFalse(Dollar(5).equals(Franc(5)))
//    }

    @Test
    fun testCurrency()
    {
        assertEquals("USD", Money.dollar(1, "USD").currency())
        assertEquals("CHF", Money.franc(1, "CHF").currency())
        assertTrue(Money.franc(1, "CHF").equals(Money.franc(1, "CHF")))
    }

    @Test
    fun testSimpleAddition()
    {
//        val sum: Money = Money.dollar(5, "USD").plus(Money.dollar(5, "USD"))
//        assertEquals(sum, Money.dollar(10, "USD").amount)
        // ($2 + 3CHF) * 5
        // 手持ちの有価証券を足し合わせていきExpressionオブジェクトにする。それを為替レートによって１つのレートに変換する
        val five: Money = Money.dollar(5, "USD")
        val sum: Expression = five.plus(five)
        val bank = Bank()
        val reduced: Money = bank.reduce(sum, "USD")
        // 書籍ではテストが通っている。kotlinでは生成されるオブジェクトのhashを比較しているのでエラーとなる。
        assertEquals(Money.dollar(10, "USD"), reduced)
    }

    @Test
    fun testPlusReturnSum()
    {
        val five: Money = Money.dollar(5, "USD")
        val result: Expression = five.plus(five)
        val sum: Sum = result as Sum
        assertTrue(five.equals(sum.augend))
        assertTrue(five.equals(sum.addend))
    }

    @Test
    fun testReduceSum() {
        val sum: Expression = Sum(Money.dollar(3, "USD"), Money.dollar(4, "USD"))
        val bank: Bank = Bank()
        val result: Money = bank.reduce(sum, "USD")
        assertTrue(Money.dollar(7, "USD").equals(result))
    }

    @Test
    fun testReduceMoney(){
        val bank: Bank = Bank()
        val result: Money = bank.reduce(Money.dollar(1, "USD"), "USD")
        assertTrue(Money.dollar(1, "USD").equals(result))
    }

    @Test
    fun testReduceMoneyDifferentCurrency()
    {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result: Money = bank.reduce(Money.franc(2, "CHF"), "USD")
        assertTrue(Money.dollar(1, "USD") == result)
    }

    @Test
    fun testMixedAddition()
    {
        val fiveBucks: Expression = Money.dollar(5, "USD")
        val tenFrans: Expression = Money.franc(10, "CHF")
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result: Money = bank.reduce(fiveBucks.plus(tenFrans), "USD")
        assertEquals(Money.dollar(10, "USD"), result)

    }

}