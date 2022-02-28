package part1basics

import scala.annotation.tailrec

object Functions extends App {
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  val result = aFunction("string", 2)
  println(result)

  def aParameterlessFunction(): Int = 4
  println(aParameterlessFunction())

  /**
   * WHEN YOU NEED LOOPS, USE RECURSION
   */
  def aRecursiveFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRecursiveFunction(aString, n - 1)
  }

  println(aRecursiveFunction("Hello ", 3))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n - 1)
  }

  /**
   * Exercises
   * 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
   * 2. Factorial function 1 * 2 * 3 * .. * n
   * 3. A Fibonacci function: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...
   *  f(1) = 1
   *  f(2) = 1
   *  f(n) = f(n - 1) + f(n - 2)
   * 4. A function that tests if a number is prime.
   */

  // 1
  def greetingFunction(name: String, age: Int): String = {
    val ageString = if (age > 1) age + " years old" else age + " year old"
    "Hi, my name is " + name + " and I am " + ageString
  }

  // 2
  def calculateFactorial(n: Int): Int = {
    if (n <= 1) n else n * calculateFactorial(n - 1)
  }

  // 3
  def calculateFibonacci(n: Int): Int = {
    if (n <= 2) 1 else calculateFibonacci(n - 1) + calculateFibonacci(n - 2)
  }

  // 4
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }

  println(isPrime(9))
}