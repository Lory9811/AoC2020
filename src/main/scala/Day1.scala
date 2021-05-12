object Day1 {
  val part1: List[String] => List[Int] = (input: List[String]) => {
    val numbers = input.map(_.toInt)
    for {
      x <- numbers
      y <- numbers
      if x + y == 2020
    } yield x * y
  }

  val part2: List[String] => List[Int] = (input: List[String]) => {
    val numbers = input.map(_.toInt)
    for {
      x <- numbers
      y <- numbers
      z <- numbers
      if x + y + z == 2020
    } yield x * y * z
  }
}
