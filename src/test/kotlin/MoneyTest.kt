import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MoneyTest {
    @Test
    fun testMultiplication()
    {
        // Explicitly given type is redundant here
        val five: Dollar = Dollar(5)
        five.times(2)
        val ten: Dollar = Dollar(10)
        assertEquals(ten.amount, five.times(2))
        five.times(3)
        assertEquals(15, five.times(3))
    }

    @Test
    fun testEquality()
    {
        assertTrue(Dollar(5).equals(Dollar(5)))
        assertFalse(Dollar(5).equals(Dollar(6)))
    }
}