import java.io.File

fun main() {
    val file = File("/Users/kornel.skorka/IdeaProjects/aoc-2021/src/main/resources/day2-data")
    partOne(file)
    partTwo(file)
}

private fun partTwo(file: File) {
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
    println(hori * depth)
}

private fun partOne(file: File) {
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
    println(hori * depth)
}
