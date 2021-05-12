package com.github.lory9811.aoc2020

import com.github.lory9811.aoc2020.days.{Day1, Day2}

object Main extends App {
  val days = List(
    Day1,
    Day2
  )

  for (day <- days) {
    val results = day.execute(Util.getInput(day.inputIndex))
    println(s"Day${day.inputIndex} results: $results")
  }
}
