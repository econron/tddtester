import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MoneyTest {
    @Test
    fun testMultiplication()
    {
        // Explicitly given type is redundant here
        val five: Dollar = Money.dollar(5, "USD")
        val ten: Dollar = Money.dollar(10, "USD")
        assertEquals(ten.amount, five.times(2))
        assertEquals(15, five.times(3))
    }

    @Test
    fun francMultiplication()
    {
        // 現時点でfranとdollarの違いはなし
        val francFive: Franc = Money.franc(5, "CHF")
        val francTen: Franc = Money.franc(10, "USD")
        assertEquals(francTen.amount, francFive.times(2))
        assertEquals(15, francFive.times(3))
    }


    @Test
    fun testEquality()
    {
        assertTrue(Dollar(5, "USD").equals(Dollar(5, "USD")))
        assertFalse(Dollar(5, "USD").equals(Dollar(6, "USD")))
    }

    // 同じテストを書いているので消したい
    @Test
    fun testFrancEquality()
    {
        assertTrue(Franc(5, "USD").equals(Franc(5, "USD")))
        assertFalse(Franc(5, "USD").equals(Franc(6, "USD")))
    }

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
        assertTrue(Money.franc(1, "CHF").equals(Franc(1, "CHF")))
    }

}