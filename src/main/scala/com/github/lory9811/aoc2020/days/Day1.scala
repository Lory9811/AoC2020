package com.github.lory9811.aoc2020.days

object Day1 extends Day {
  override val inputIndex: Int = 1

  override def part1(input: List[String]): Int = {
    val numbers = input.map(_.toInt)
    (for {
      x <- numbers
      y <- numbers
      if x + y == 2020
    } yield x * y).head
  }

  override def part2(input: List[String]): Int = {
    val numbers = input.map(_.toInt)
    (for {
      x <- numbers
      y <- numbers
      z <- numbers
      if x + y + z == 2020
    } yield x * y * z).head
  }

  override def execute(input: List[String]): (Int, Int) = {
    (part1(input), part2(input))
  }
}
