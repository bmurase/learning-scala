package part2oop

import scala.language.postfixOps

object OOBasicsExercises extends App {
  /**
   * Exercises
   * Implement classes for a novel and a writer
   *
   * Writer: first name, surname, year of birth
   * - method: full name (first name + surname)
   *
   * Novel: name, year of release, author (instance of writer)
   * - authorAge: age of the author at the year of release
   * - isWrittenBy(author)
   * - copy(new year of release) = new instance of Novel with a new year of release (author expanded or revised the edition)
   */
  println("Writer and novel")

  val author = new Writer("Gege", "Akutami", 1992)
  val novel = new Novel("Jujutsu Kaisen", 2018, author)
  println(author.fullName)
  println(novel.authorAgeAtRelease)
  println(novel.isWrittenBy(author))

  val newEdition = novel.copy(2022)
  println(newEdition.authorAgeAtRelease)

  /**
   * Counter class
   * - receives an int value
   * - has a method which return current count
   * - method to increment/decrement => new Counter
   * - overload inc/dec methods to receive an amount to +/- the counter => new Counter
   */
  println("Counter")

  val counter = new Counter(2)
  println(counter.currentCount)
  println(counter.decrement().currentCount)
  println(counter.increment().currentCount)
  println(counter.increment(4).currentCount)
  println(counter.decrement(4).currentCount)
}

class Writer(firstName: String, surname: String, val birthYear: Int) {
  def fullName: String = firstName + " " + surname
}

class Novel(title: String, releaseYear: Int, author: Writer) {
  def authorAgeAtRelease: Int = releaseYear - author.birthYear
  def isWrittenBy(author: Writer): Boolean = this.author == author
  def copy(newReleaseYear: Int): Novel = new Novel(this.title, newReleaseYear, this.author)
}

class Counter(initialValue: Int) {
  def currentCount: Int = initialValue

  private def changeValue(amount: Int): Counter = new Counter(initialValue + amount)
  def increment(): Counter = changeValue(1)
  def decrement(): Counter = changeValue(-1)
  def increment(amount: Int): Counter = changeValue(amount)
  def decrement(amount: Int): Counter = changeValue(-amount)
}

class AnotherCounter(val count: Int = 0) {
  def increment: AnotherCounter = {
    println("incrementing")
    new AnotherCounter(count + 1)
  }

  def decrement: AnotherCounter = {
    println("decrementing")
    new AnotherCounter(count - 1)
  }

  def increment(n: Int): AnotherCounter = {
    if (n <= 0) this
    else increment.increment(n - 1)
  }

  def decrement(n: Int): AnotherCounter = {
    if (n <= 0) this
    else decrement.decrement(n - 1)
  }
}