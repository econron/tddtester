import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MoneyTest {
    @Test
    fun testMultiplication()
    {
        // Explicitly given type is redundant here
        val five: Dollar = Dollar(5)
        val ten: Dollar = Dollar(10)
        assertEquals(ten.amount, five.times(2))
        assertEquals(15, five.times(3))
    }

    @Test
    fun francMultiplication()
    {
        val francFive: Franc = Franc(5)
        val francTen: Franc = Franc(10)
        assertEquals(francTen.amount, francFive.times(2))
        assertEquals(15, francFive.times(3))
    }


    @Test
    fun testEquality()
    {
        assertTrue(Dollar(5).equals(Dollar(5)))
        assertFalse(Dollar(5).equals(Dollar(6)))
    }

    // 同じテストを書いているので消したい
    @Test
    fun testFrancEquality()
    {
        assertTrue(Franc(5).equals(Franc(5)))
        assertFalse(Franc(5).equals(Franc(6)))
    }

    @Test
    fun testEqualityBetweenDollarAndFranc()
    {
        assertFalse(Dollar(5).equals(Franc(5)))
    }


}