package part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {
  @tailrec
  def factorialTailRec(n: Int, accumulator: Int = 1): Int =
    if (n <= 1) accumulator
    else factorialTailRec(n - 1, n * accumulator)

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("Saving picture...")

  savePicture(width = 800, height = 600)
}
