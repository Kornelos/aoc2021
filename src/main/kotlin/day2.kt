fun main() {
    val day = Day2()
    day.run1st()
    day.run2nd()
}

class Day2 : Day(2) {
    override fun partTwo(): Int {
        var hori = 0
        var depth = 0
        var aim = 0
        file.useLines {
            it.forEach { line ->
                val values = line.split(' ')
                val x = values[1].toInt()
                when (values[0]) {
                    "forward" -> {
                        hori += x
                        depth += aim * x
                    }
                    "up" -> aim -= x
                    "down" -> aim += x
                }
            }
        }
        return hori * depth
    }

    override fun partOne(): Int {
        var hori = 0
        var depth = 0
        file.useLines {
            it.forEach { line ->
                val values = line.split(' ')
                when (values[0]) {
                    "forward" -> hori += values[1].toInt()
                    "up" -> depth -= values[1].toInt()
                    "down" -> depth += values[1].toInt()
                }
            }
        }
        return hori * depth
    }
}