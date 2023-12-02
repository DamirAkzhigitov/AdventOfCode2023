import java.lang.Character.isDigit
fun main() {
    fun part1(input: List<String>): Int {
        println(input)

        return input.sumOf { calcCalValue(it) }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

fun calcCalValue(value: String): Int {
    var firstInt: String = ""
    var lastInt: String = ""

    for (x in value.indices) {
        val firstValue = value[x]
        val lastValue = value[(value.length - 1) - x]

        if (firstInt.isEmpty() && isDigit(firstValue)) {
            firstInt = firstValue.toString()
        }
        if (lastInt.isEmpty() && isDigit(lastValue)) {
            lastInt = lastValue.toString()
        }
        if (firstInt.isNotEmpty() && lastInt.isNotEmpty()) {
            break
        }
    }

    return (firstInt + lastInt).toInt()
}