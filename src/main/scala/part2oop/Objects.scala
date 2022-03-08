package part2oop

object Objects extends App {
  /**
   * Scala does not have class-level functionality ("static")
   *
   * class Person {
   *  public static final int N_EYES = 2
   * }
   *
   * public class JavaPlayground {
   *  public static void main(String args[]) {
   *    System.out.println(Person.N_EYES)
   *  }
   * }
   */

  // Scala objects don't receive parameters
  // to use class-level functionality in Scala we use objects
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    def from(mother: Person, father: Person): Person = new Person("Bobby")
  }

  println(Person.N_EYES)
  println(Person.canFly)

  /**
   * Scala object = SINGLETON INSTANCE
   * So the object person is a type and also its only instance
   */
  val mary = Person
  val john = Person

  println(
    if (mary == john) "mary and john represent the same instance"
    else "mary and john are different instances"
  )

  // We can create a Person class to set instance-level functionality
  class Person(val name: String) {}

  /**
   * The pattern in which we write an object and a class with the same name
   * and in the same scope (file) is called COMPANIONS
   * Scala companions can access each other's private members
   */

  /**
   * Factory method
   * A method that its whole purpose is to build/create a new Person
   * given some parameters
   *
   * Often, the factory method is conveniently called apply
   * So we could actually call it by doing Person(laurie, joseph)
   */
  val laurie = new Person("Laurie")
  val joseph = new Person("Joseph")
  val bobby = Person.from(laurie, joseph)

  /**
   * Scala applications
   * Why this code is runnable?
   * it's a Scala object with a particular method:
   * def main(args: Array[String]): Unit
   */
}
