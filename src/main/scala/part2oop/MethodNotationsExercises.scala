package part2oop

import scala.language.postfixOps

object MethodNotationsExercises extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"Shout out to $name"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    def +(nickname: String): Person = {
      val newName = s"$name ($nickname)"
      new Person(newName, favoriteMovie, age)
    }

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def learns(subject: String): String = s"$name learns $subject"

    def learnsScala: String = this learns "Scala"

    def apply(timesWatchingFavoriteMovie: Int): String =
      s"$name watched $favoriteMovie $timesWatchingFavoriteMovie ${
        if (timesWatchingFavoriteMovie > 1) "times" else "time"
      }"
  }

  val mary = new Person("Mary", "Memento", 22)

  /**
   * 1. overload the + operator which receives a string and
   * returns a person with that nickname
   * mary + "the rockstar" => new Person "Mary (the rockstar)"
   */
  val maryTheRockstar = mary + "The Rockstar"
  println(maryTheRockstar.name)

  /**
   * 2. add an age to the Person class
   * add a unary + operator => new Person with that age + 1
   * +mary => mary with the age incremented
   */
  val olderMary = +mary
  println(olderMary.age)

  /**
   * 3. add a "learns" method in the Person class
   * receives a string and returns a sentence which says
   * "Mary learns ..."
   */
  println(mary learns "Biology")

  /**
   * 4. add a learnsScala method that doesn't receive any parameters
   * and calls learns("Scala")
   * use it in postfix notation
   */
  println(mary learnsScala)

  /**
   * 5. overload apply method
   * to receive a number and return a string
   * marry.apply(2) => "Mary watched Inception 2 times"
   */
  println(mary(2))
  println(mary(1))
}