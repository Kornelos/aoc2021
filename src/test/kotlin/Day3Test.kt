import org.junit.jupiter.api.Test
import java.io.StringReader
import kotlin.test.assertEquals

class Day3Test {
    val day = Day3()

    val testInput = """
        00100
        11110
        10110
        10111
        10101
        01111
        00111
        11100
        10000
        11001
        00010
        01010
    """.trimIndent()

    @Test
    fun calculateCorrect1st(){
        val result = day.calculateGammaEpsilon(StringReader(testInput).readLines())
        assertEquals(198, result)
    }

    @Test
    fun calculate2nd(){
        val result = day.calculateCo2Oxygen(StringReader(testInput).readLines())
        assertEquals(230,result)
    }

    @Test
    fun mostFrequentBitAtTest(){
        val simpleInput ="""
            010
            101
            100
            101
        """.trimIndent()


        assertEquals( '1', day.mostFrequentBitAt(StringReader(simpleInput).readLines(),0))
        assertEquals( '0', day.mostFrequentBitAt(StringReader(simpleInput).readLines(),1))
        assertEquals( '1', day.mostFrequentBitAt(StringReader(simpleInput).readLines(),2))
    }
    @Test
    fun leastFrequentBitAtTest(){
        val simpleInput ="""
            010
            101
            100
            101
        """.trimIndent()


        assertEquals( '0', day.leastFrequentBitAt(StringReader(simpleInput).readLines(),0))
        assertEquals( '1', day.leastFrequentBitAt(StringReader(simpleInput).readLines(),1))
        assertEquals( '0', day.leastFrequentBitAt(StringReader(simpleInput).readLines(),2))
    }
}