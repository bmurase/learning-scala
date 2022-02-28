package part1basics

object Expressions extends App {
  val x = 1 + 2
  println(x)

  val xIsEven = x % 2 == 0
  val xIsOdd = !xIsEven

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= these are all side effects
  println(aVariable)

  /**
   * Instructions vs Expressions
   * - Instructions are what you tell the computer to DO: change a variable, print to the console...
   * - Expressions have a value and/or a type
   */

  // IF expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 8 else 3

  println(aConditionedValue)
  // IF is as an expression and not an instruction
  println(if (aCondition) "expression" else "instruction")

  // NEVER WRITE THIS AGAIN
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // EVERYTHING in Scala is an expression

  val aWeirdValue: Unit = (aVariable = 3)
  println(aWeirdValue)

  // side effects are: println(), whiles, reassigning (they are expressions that return Unit)

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 3

    if (z > 2) "z is greater than two" else "z is less or equal to two"
  }

  println(aCodeBlock)
}
