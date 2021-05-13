package com.github.lory9811.aoc2020.days

object Day5 extends Day {
  override val inputIndex: Int = 5

  def findPos(input: String, zero: String, one: String): Int = {
    val binaryString = input.replace(zero, "0").replace(one, "1")
    Integer.parseInt(binaryString, 2)
  }

  def findId(input: String): Int = {
    val binaryString = input.replace("F", "0").replace("B", "1")
      .replace("L", "0").replace("R", "1")
    Integer.parseInt(binaryString, 2)
  }

  override def part1(input: List[String]): Int = {
    input.map(findId).max
  }

  override def part2(input: List[String]): Int = 0
}
