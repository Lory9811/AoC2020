package com.github.lory9811.aoc2020.days

object Day2 {
  private val validatePassword = (input: String) => {
    val tokens = input.split(':').map(_.strip)
    val (min, max, letter) = parsePasswordPattern(tokens(0))
    val password = tokens(1)
    val count = password.count(_ == letter)
    if (min to max contains count) true else false
  }

  private val validatePassword2 = (input: String) => {
    val tokens = input.split(':').map(_.strip)
    val (pos0, pos1, letter) = parsePasswordPattern(tokens(0))
    val password = tokens(1)
    (password(pos0 - 1) == letter || password(pos1 - 1) == letter) && !(password(pos0 - 1) == letter && password(pos1 - 1) == letter)
  }

  private val parsePasswordPattern = (pattern: String) => {
    val tokens = pattern.split("[- ]")
    (tokens(0).toInt, tokens(1).toInt, tokens(2)(0))
  }

  val part1: List[String] => Int = (input: List[String]) => {
    input.map(validatePassword).count(_ == true)
  }

  val part2: List[String] => Int = (input: List[String]) => {
    input.map(validatePassword2).count(_ == true)
  }
}
