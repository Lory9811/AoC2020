package com.github.lory9811.aoc2020.days

object Day3 extends Day {
  override val inputIndex: Int = 3

  private case class Vector2(var x: Int, var y: Int) {
    def +(other: Vector2): Vector2 = {
      Vector2(x + other.x, y + other.y)
    }
  }

  private object Vector2 {
    def apply(ints: (Int, Int)): Vector2 = Vector2(ints._1, ints._2)
  }

  private class Map(mapData: Set[Vector2], dimensions: Vector2) {
    def testCollision(position: Vector2): Boolean = {
      mapData.contains(Vector2(position.x % dimensions.x, position.y))
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
        } yield Vector2(x, y)).toSet,
        Vector2(input.head.length, input.size)
    )
  }

  private def getCollisions(start: Vector2, slope: Vector2, map: Map): Int = {
    var currentPos = start
    var collisions = 0
    while (currentPos.y < map.height) {
      if (map.testCollision(currentPos)) collisions += 1
      currentPos += slope
    }
    collisions
  }

  override def part1(input: List[String]): Int = {
    val slope = Vector2(3, 1)
    val map = Map(input)
    getCollisions(Vector2(0, 0), slope, map)
  }

  override def part2(input: List[String]): Int = {
    val slopes = Set((1, 1), (3, 1), (5, 1), (7, 1), (1, 2)).map(Vector2(_))
    val map = Map(input)
    (for (slope <- slopes) yield getCollisions(Vector2(0, 0), slope, map)).product
  }
}
