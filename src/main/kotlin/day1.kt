fun main() {
    val day = DayOne()
    day.run1st()
    day.run2nd()
}

class DayOne : Day(1) {
    override fun partTwo(): Int {
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
        return count
    }

    override fun partOne(): Int {
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
        return count
    }
}