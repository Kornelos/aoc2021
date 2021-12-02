#!/bin/zsh

day_num_zero=$(date +%d)
day_num=$((10#$day_num_zero))
echo "Downloading data for day $day_num"

# this curl needs cookie
my_cookie=$(<cookies.txt)
curl -H "cookie: session='$my_cookie'" https://adventofcode.com/2021/day/"$day_num"/input >> /Users/kornel.skorka/IdeaProjects/aoc-2021/src/main/resources/day"$day_num"-data

echo "Preparing kt file for day $day_num"
echo "import java.io.File

 fun main() {
     val file = File(\"/Users/kornel.skorka/IdeaProjects/aoc-2021/src/main/resources/day$day_num-data\")
     partOne(file)
     partTwo(file)
 }

 private fun partTwo(file: File) {

 }

 private fun partOne(file: File) {

 }" >> /Users/kornel.skorka/IdeaProjects/aoc-2021/src/main/kotlin/day"$day_num".kt