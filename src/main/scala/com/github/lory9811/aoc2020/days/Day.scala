package com.github.lory9811.aoc2020.days

trait Day {
  val inputIndex: Int
  def part1(input: List[String]): Int
  def part2(input: List[String]): Int
  def execute(input: List[String]): (Int, Int) = (part1(input), part2(input))
}
