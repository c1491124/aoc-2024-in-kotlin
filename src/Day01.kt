import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val firstList = emptyList<Int>().toMutableList()
        val secondList = emptyList<Int>().toMutableList()
        input.forEach {
            it.split("   ")
                .map { it.toInt() }
                .let {
                    firstList += it[0]
                    secondList += it[1]
                }
        }
        var sum = 0
        for ((index, value) in firstList.sorted().withIndex()) {
            sum += (value - secondList.sorted()[index]).absoluteValue
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val pairs = input.map { line ->
            val values = line.split("   ").map { it.toInt() }
            values[0] to values[1]
        }
        val firstList = pairs.map { it.first }
        val secondList = pairs.map { it.second }

        return firstList.sumOf { firstValue -> firstValue * secondList.count { it == firstValue } }
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt.txt` file:
    //val testInput = readInput("Day01_test.txt")
    //check(part1(testInput) == 6)


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
