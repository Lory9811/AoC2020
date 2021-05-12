package com.github.lory9811.aoc2020.days

object Day4 extends Day {
  override val inputIndex: Int = 4

  private def parseInput(input: List[String]): List[String] = {
    input.mkString("\n").split("\n\n").toList.map(_.replace("\n", " "))
  }

  private def createPassport(passport: String): Map[String, String] = {
    passport.split(" ").map(_.split(":")).map(x => (x.head, x.tail.mkString(""))).toMap
  }

  private def checkValidity(passport: Map[String, String], requiredFields: Set[String]) = {
    requiredFields.subsetOf(passport.keySet)
  }

  override def part1(input: List[String]): Int = {
    val passports = parseInput(input).map(createPassport)
    val requiredFields = Set("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    passports.map(checkValidity(_, requiredFields)).count(_ == true)
  }

  override def part2(input: List[String]): Int = 0
}
