package com.github.lory9811.aoc2020.days

object Day2 extends Day {
  override val inputIndex: Int = 2

  private def validatePassword(input: String): Boolean = {
    val tokens = input.split(':').map(_.strip)
    val (min, max, letter) = parsePasswordPattern(tokens(0))
    val password = tokens(1)
    val count = password.count(_ == letter)
    if (min to max contains count) true else false
  }

  private def validatePassword2(input: String): Boolean = {
    val tokens = input.split(':').map(_.strip)
    val (pos0, pos1, letter) = parsePasswordPattern(tokens(0))
    val password = tokens(1)
    (password(pos0 - 1) == letter || password(pos1 - 1) == letter) && !(password(pos0 - 1) == letter && password(pos1 - 1) == letter)
  }

  private def parsePasswordPattern(pattern: String): (Int, Int, Char) = {
    val tokens = pattern.split("[- ]")
    (tokens(0).toInt, tokens(1).toInt, tokens(2)(0))
  }

  override def part1(input: List[String]): Int = {
    input.map(validatePassword).count(_ == true)
  }

  override def part2(input: List[String]): Int = {
    input.map(validatePassword2).count(_ == true)
  }

  override def execute(input: List[String]): (Int, Int) = {
    (part1(input), part2(input))
  }
}
