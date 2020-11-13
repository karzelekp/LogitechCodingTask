package pl.karzelek.logitechcodingtask.robbery

import java.lang.Integer.max
import java.util.*

class RobberyCalculator {

    fun calculate(moneyPerHouses: Vector<Int>): Int {
        println("moneyPerHouses:\t$moneyPerHouses")
        if (moneyPerHouses.any { it < 0 }) {
            println("money shouldn't be negative, aborting calculation")
            return 0
        }
        return when (moneyPerHouses.size) {
            0 -> 0
            1 -> moneyPerHouses.first()
            else -> calculateWhenAtLeast2size(moneyPerHouses)
        }
    }

    private fun calculateWhenAtLeast2size(moneyPerHouses: Vector<Int>): Int {
        println("calculations:")

        var previous = 0
        var current = 0
        moneyPerHouses.forEach {
            val next = max(it + previous, current)
            previous = current
            current = next
            println(next)
        }
        return current
    }
}