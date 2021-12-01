import java.io.File

fun main() {
    val file = File("/Users/kornel.skorka/IdeaProjects/aoc-2021/src/main/resources/day1-data")
    partOne(file)
    partTwo(file)
}

private fun partTwo(file: File) {
    var lastDepthSum = Int.MAX_VALUE
    var count = 0
    file.useLines {
        it.map(String::toInt).windowed(3).forEach { window ->
            val depthSum = window.sum()
            if (depthSum > lastDepthSum) {
                count += 1
            }
            lastDepthSum = depthSum
        }
    }
    println(count)
}

private fun partOne(file: File) {
    var lastDepth = Int.MAX_VALUE
    var count = 0
    file.useLines {
        it.map(String::toInt).forEach { depth ->
            if (depth > lastDepth) {
                count += 1
            }
            lastDepth = depth
        }
    }
    println(count)
}