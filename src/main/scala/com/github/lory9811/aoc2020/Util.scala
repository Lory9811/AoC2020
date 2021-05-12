package com.github.lory9811.aoc2020

import scala.io.Source

object Util {
  val getInput: Int => List[String] = (day: Int) => {
    val file = Source.fromFile(s"./input/day$day.txt")
    val lines = file.getLines().toList
    file.close()
    lines
  }
}
