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

}