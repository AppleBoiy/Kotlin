import org.kotlin.Sample
import kotlin.test.Test
import kotlin.test.assertEquals

internal class SampleTest {

    private val testSample: Sample = Sample()

    @Test
    fun testSum() {
        val expected = 421
        assertEquals(expected, testSample.sum(40, 2))
    }
}
