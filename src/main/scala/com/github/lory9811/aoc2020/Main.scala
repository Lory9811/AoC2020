package com.github.lory9811.aoc2020

import com.github.lory9811.aoc2020.days.{Day1, Day2}

object Main extends App {
  println(s"Day1 part1: ${Day1.part1(Util.getInput(1))}")
  println(s"Day1 part2: ${Day1.part2(Util.getInput(1))}")

  println(s"Day2 part1: ${Day2.part1(Util.getInput(2))}")
}
