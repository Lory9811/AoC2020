package com.github.lory9811.aoc2020.days

object Day8 extends Day {
  override val inputIndex: Int = 8

  private case class State(acc: Int, pc: Int)

  private def nop(arg: Int, state: State): State = {
    State(state.acc, state.pc + 1)
  }

  private def acc(arg: Int, state: State): State = {
    State(state.acc + arg, state.pc + 1)
  }

  private def jmp(arg: Int, state: State): State = {
    State(state.acc, state.pc + arg)
  }

  private def parseInput(input: String): State => State = {
    val op = input.split(" ")
    val arg = op(1).toInt
    op(0) match {
      case "nop" => nop(arg, _)
      case "acc" => acc(arg, _)
      case "jmp" => jmp(arg, _)
      case _ => nop(arg, _)
    }
  }

  override def part1(input: List[String]): Int = {
    val instructions = input.map(x => (parseInput(x), false)).toArray
    var state = State(0, 0)
    while (!instructions(state.pc)._2) {
      instructions(state.pc) = (instructions(state.pc)._1, true)
      state = instructions(state.pc)._1(state)
    }
    state.acc
  }

  override def part2(input: List[String]): Int = 0
}
