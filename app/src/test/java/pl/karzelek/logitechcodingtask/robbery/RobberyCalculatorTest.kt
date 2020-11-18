package pl.karzelek.logitechcodingtask.robbery

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*

@RunWith(Parameterized::class)
class RobberyCalculatorTest(
    private val params: TestParams
) {

    @Test
    fun test() {
        //when
        println("testing: ${params.message}")
        val result = RobberyCalculator().calculate(params.moneyPerHouses.toVector())
        //then
        println("result:$result\n")
        assertEquals(params.message, params.expectedResult, result)
    }

    private fun <T> Collection<T>.toVector() = Vector(this)

    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun params() = arrayOf(
            TestParams(emptyList(), 0, "empty"),
            TestParams(listOf(13), 13, "single element"),
            TestParams(listOf(13, 7), 13, "two elements"),
            TestParams(listOf(1, 2, 3, 1), 4, "task's example"),
            TestParams(
                listOf(0, 0, 10, 2, 3, 10),
                20,
                "the result should contain one number at even index and one at odd index"
            ),
            TestParams(listOf(-3), 0, "negative number")
        )
    }

    data class TestParams(
        val moneyPerHouses: List<Int>,
        val expectedResult: Int,
        val message: String
    )
}