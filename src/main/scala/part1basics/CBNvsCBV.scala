package part1basics

/**
 * Call-by-Name vs Call-by-Value
 */
object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  /**
   * value is computed before call
   * same value is used everywhere
   */
  calledByValue(System.nanoTime())

  /**
   * the parameter is not a value, it's an expression
   * expression is passed literally
   * expression is evaluated at every use within
   */
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)

  /**
   * this crashes because infinite() is passed by value
   * printFirst(infinite(), 34)
   *
   * with swapped parameters, infinite is passed by name and it's never executed because the parameter is not used
   * in the function's implementation
   */
  printFirst(34, infinite())

}
