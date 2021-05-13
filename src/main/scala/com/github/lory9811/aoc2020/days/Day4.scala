package com.github.lory9811.aoc2020.days

object Day4 extends Day {
  override val inputIndex: Int = 4

  private def parseInput(input: List[String]): List[String] = {
    input.mkString("\n").split("\n\n").toList.map(_.replace("\n", " "))
  }

  private def createPassport(passport: String): Map[String, String] = {
    passport.split(" ").map(_.split(":")).map(x => (x.head, x.tail.mkString(""))).toMap
  }

  private def checkValidity(passport: Map[String, String], requiredFields: Set[String]): Boolean = {
    requiredFields.subsetOf(passport.keySet)
  }

  private def checkValidity2(passport: Map[String, String]): Boolean = {
    def matchYear(input: String, range: Range): Boolean = {
      try {
        (input.length == 4) && (range contains input.toInt)
      } catch {
        case e: NumberFormatException => false
      }
    }

    def matchHeight(input: String): Boolean = {
      val heightPattern = "([0-9]+)(cm|in)".r
      heightPattern.findFirstMatchIn(input) match {
        case Some(patternMatch) =>
          val range = patternMatch.group(2) match {
            case "cm" => 150 to 193
            case "in" => 59 to 76
          }
          try {
            range contains patternMatch.group(1).toInt
          } catch {
            case e: NumberFormatException => false
          }
        case None => false
      }
    }

    val requiredFields = Set("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    checkValidity(passport, requiredFields) &&
    (for {
      (k, v) <- passport
    } yield k match {
      case "byr" => matchYear(v, 1920 to 2002)
      case "iyr" => matchYear(v, 2010 to 2020)
      case "eyr" => matchYear(v, 2020 to 2030)
      case "hgt" => matchHeight(v)
      case "hcl" => v.matches("#[0-9a-f]{6}")
      case "ecl" => Set("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(v)
      case "pid" => v.matches("[0-9]{9}")
      case "cid" => true
    }).forall(_ == true)
  }

  override def part1(input: List[String]): Int = {
    val passports = parseInput(input).map(createPassport)
    val requiredFields = Set("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    passports.map(checkValidity(_, requiredFields)).count(_ == true)
  }

  override def part2(input: List[String]): Int = {
    val passports = parseInput(input).map(createPassport)
    passports.map(checkValidity2).count(_ == true)
  }
}
