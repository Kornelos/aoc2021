fun main() {
    val day = Day3()
    day.run1st()
    day.run2nd()
}


class Day3 : Day(3) {

    override fun partTwo(): Int {
        return calculateCo2Oxygen(file.readLines())
    }

    fun calculateCo2Oxygen(lines: List<String>): Int {
        var i = 0
        var oxyList = lines.toMutableList()
        while (i < lines.size) {
            if (oxyList.size != 1) {
                val mostFrequentBit = mostFrequentBitAt(oxyList, i)
                oxyList = oxyList.filter { it[i] == mostFrequentBit }.toMutableList()
            } else {
                break
            }
            i += 1
        }

        i = 0
        var co2List = lines.toMutableList()
        while (i < lines.size) {
            if (co2List.size != 1) {
                val leastFrequentBit = leastFrequentBitAt(oxyList, i)
                co2List = co2List.filter { it[i] == leastFrequentBit }.toMutableList()
            } else {
                break
            }
            i += 1
        }
        return (oxyList.first().toInt(2) * co2List.first().toInt(2))
    }

    fun leastFrequentBitAt(lines: List<String>, idx: Int): Char {
        var zeros = 0
        var ones = 0
        lines.map { it[idx] }.forEach { bit ->
            if (bit == '0') {
                zeros += 1
            } else {
                ones += 1
            }
        }
        return if (ones < zeros) '1' else '0'
    }

    fun mostFrequentBitAt(lines: List<String>, idx: Int): Char {
        var zeros = 0
        var ones = 0
        lines.map { it[idx] }.forEach { bit ->
            if (bit == '0') {
                zeros += 1
            } else {
                ones += 1
            }
        }
        return if (ones >= zeros) '1' else '0'
    }

    override fun partOne(): Int {
        return calculateGammaEpsilon(file.readLines())
    }

    fun calculateGammaEpsilon(input: List<String>): Int {
        val results = bitFrequency(input)
        val gamma = Integer.parseInt(results.map { if (it[0] > it[1]) '0' else '1' }.joinToString("").reversed(), 2)
        val epsilon = Integer.parseInt(results.map { if (it[0] < it[1]) '0' else '1' }.joinToString("").reversed(), 2)
        return (gamma * epsilon)
    }

    fun bitFrequency(input: List<String>): MutableList<MutableList<Int>> {
        val results = generateSequence { mutableListOf(0, 0) }.take(input.first().length).toMutableList()

        input.map(String::toCharArray).map { it.map(Char::digitToInt) }.forEach { binary ->
            var iter = 0
            binary.reversed().forEach { digit ->
                if (digit == 0) {
                    results[iter][0] += 1
                } else {
                    results[iter][1] += 1
                }
                iter += 1
            }

        }
        return results
    }
}