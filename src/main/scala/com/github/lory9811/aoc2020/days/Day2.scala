package com.github.lory9811.aoc2020.days

object Day2 {
  private val validatePassword = (input: String) => {
    val tokens = input.split(':').map(_.strip)
    val (min, max, letter) = parsePasswordPattern(tokens(0))
    val password = tokens(1)
    val count = password.count(_ == letter)
    if (min to max contains count) true else false
  }

  private val parsePasswordPattern = (pattern: String) => {
    val tokens = pattern.split("[- ]")
    (tokens(0).toInt, tokens(1).toInt, tokens(2)(0))
  }

  val part1: List[String] => Int = (input: List[String]) => {
    input.map(validatePassword).count(_ == true)
  }
}
