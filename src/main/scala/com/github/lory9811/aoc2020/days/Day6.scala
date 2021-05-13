package com.github.lory9811.aoc2020.days

object Day6 extends Day {
  override val inputIndex: Int = 6

  private def parseInput(input: List[String]): List[String] = {
    input.mkString("\n").split("\n\n").toList.map(_.replace("\n", " "))
  }

  private def getVotes(input: String): Int = {
    input.replace(" ", "").toSet.size
  }

  private def getVotesForGroup(input: String): Int = {
    val votesPerPerson = input.split(" ")
    val sets = votesPerPerson.map(_.toSet)
    sets.reduce(_.intersect(_)).size
  }

  override def part1(input: List[String]): Int = {
    val groups = parseInput(input)
    groups.map(getVotes).sum
  }

  override def part2(input: List[String]): Int = {
    val groups = parseInput(input)
    groups.map(getVotesForGroup).sum
  }
}
