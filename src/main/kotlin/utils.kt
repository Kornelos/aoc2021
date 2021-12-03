import java.io.File

abstract class Day(num: Int){

    val file = File("/Users/kornel.skorka/IdeaProjects/aoc-2021/src/main/resources/day$num-data")

    abstract fun partOne(): Any
    abstract fun partTwo(): Any

}

fun Day.run1st(){
    println("1st part:")
    println(partOne())
}

fun Day.run2nd(){
    println("2nd part:")
    println(partTwo())
}