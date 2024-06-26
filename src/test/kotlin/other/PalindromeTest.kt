package other

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PalindromeTest {
    @Test
    fun testPalindromePortuguesePhrase() {
        val text = "A mãe te ama"
        assertTrue(isPalindrome(text))
    }

    @Test
    fun testPalindromeEnglishPhrase() {
        val text = "Mr Owl ate my metal worm"
        assertTrue(isPalindrome(text))
    }

    @Test
    fun testPalindromeName() {
        val text = "Hannah"
        assertTrue(isPalindrome(text))
    }

    @Test
    fun testPalindromeNumber() {
        val text = "2002"
        assertTrue(isPalindrome(text))
    }
}
