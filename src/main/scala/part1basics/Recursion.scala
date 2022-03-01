package part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }

  /**
   * when we use the above function for n = 5000, for example, we get a StackOverflowException
   * to avoid that, we must use tail recursion
   */
  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factorialHelper(n, 1)
  }

//  println(anotherFactorial(5000))

  /**
   * Exercices
   * 1. Concatenate a string n times
   * 2. IsPrime function tail recursive
   * 3. Fibonacci function tail recursive
   */

  // 1
  def concatenateString(aString: String, n: Int): String = {
    @tailrec
    def concatenateHelper(x: Int, accumulator: String): String = {
      if (x <= 1) accumulator
      else concatenateHelper(x - 1, aString + accumulator)
    }

    concatenateHelper(n, aString)
  }

  // 2
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailRec(n / 2, true)
  }

  // 3
  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibonacciTailRec(i + 1, last = last + nextToLast, nextToLast = last)

    if (n <= 2) 1
    else fibonacciTailRec(2, 1, 1)
  }
}
