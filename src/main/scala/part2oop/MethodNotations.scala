package part2oop

import scala.language.postfixOps

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"Shout out to $name"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Memento")

  // infix notation = operator notation (that's a syntactic sugar - nicer ways of writing code)
  // only works with methods with a single parameter
  println(mary.likes("Memento"))
  println(mary likes "Memento")

  // "operators" in Scala
  val tom = new Person("Tom", "Inception")
  println(mary hangOutWith tom)
  println(mary + tom)
  println(mary.+(tom))

  // 1 + 2 is the same as using the first number's method \+\ with the second number as the parameter
  // ALL OPERATORS ARE METHODS
  println(1 + 2)
  println(1.+(2))

  // Akka actors have operators like ! ?

  // prefix notation - all about unary operators that are also methods
  val x = -1      // equivalent to val y = 1.unary_-
  println(!mary)  // equivalent to mary.unary_!

  // postfix notation - only for methods without parameters
  println(mary.isAlive)
  println(mary isAlive)

  // apply - has a special property in Scala - must have parenthesis
  println(mary.apply())
  println(mary()) // equivalent

  /**
   * Exercises
   * 1. overload the + operator which receives a string and
   * returns a person with that nickname
   *  mary + "the rockstar" => new Person "Mary (the rockstar)"
   *
   * 2. add an age to the Person class
   *  add a unary + operator => new Person with that age + 1
   *  +mary => mary with the age incremented
   *
   * 3. add a "learns" method in the Person class
   *  receives a string and returns a sentence which says
   *  "Mary learns ..."
   *
   * 4. add a learnsScala method that doesn't receive any parameters
   *  and calls learns("Scala")
   *  use it in postfix notation
   *
   * 5. overload apply method
   *  to receive a number and return a string
   *  marry.apply(2) => "Mary watched Inception 2 times"
   */
}
