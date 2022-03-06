package part2oop

object OOBasics extends App {
  val person = new Person("Bia", 24)
  val personWithFields = new PersonWithFields("Bia", 24)
  println(personWithFields.name)

  println(person.x)
  println(person.greet("Miwa"))
  println(person.greet())
}

// constructor
class Person(name: String, age: Int) {
  // class' body

  // this val is a field, so it can be accessed from outside
  val x = 2

  def someMethod() = 2

  // this.name is not a field but it can be used from inside the class
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // since there is no parameter >name< it is implied that $name equals to this.name
  // this is also an example of OVERLOADING (methods with the same name but different signatures)
  def greet(): Unit = println(s"Hi, I am $name")

  /**
   * the compiler won't understang if two methods have the same name, same parameters but returning the same data type
   * this is not acceptable:
   * def greet(): Int = 2
   */

  // multiple constructors: used only for default parameters, so you can avoid that by setting a default parameter
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

// class parameters ARE NOT FIELDS

class PersonWithFields(val name: String, age: Int) // it can also be a VAR