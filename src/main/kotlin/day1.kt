import java.io.File

fun main() {
    var lastDepth = Int.MAX_VALUE
    var count = 0
        File("/Users/kornel.skorka/IdeaProjects/aoc-2021/src/main/resources/day1-data").useLines {
        it.forEach { depth ->
            if (depth.toInt() > lastDepth) {
                count += 1
            }
            lastDepth = depth.toInt()
        }
    }
    println(count)
}