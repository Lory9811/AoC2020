package com.github.lory9811.aoc2020.days

object Day3 extends Day {
  override val inputIndex: Int = 3

  private class Vector2(var x: Int, var y: Int) {
    def +(other: Vector2): Vector2 = {
      new Vector2(x + other.x, y + other.y)
    }
  }

  private class Map(mapData: Set[(Int, Int)], dimensions: Vector2) {
    def testCollision(position: Vector2): Boolean = {
      mapData.contains((position.x % dimensions.x, position.y))
    }

    def width: Int = dimensions.x
    def height: Int = dimensions.y
  }

  private object Map {
    def apply(input: List[String]): Map = new Map(
        (for {
          y <- input.indices
          x <- input(y).indices
          if input(y)(x) == '#'
        } yield (x, y)).toSet,
        new Vector2(input.head.length, input.size)
    )
  }

  override def part1(input: List[String]): Int = {
    val slope = new Vector2(3, 1)
    val map = Map(input)
    var currentPos = new Vector2(0, 0)
    var collisions = 0
    while (currentPos.y < map.height) {
      if (map.testCollision(currentPos)) collisions += 1
      currentPos += slope
    }
    collisions
  }

  override def part2(input: List[String]): Int = 0
}
