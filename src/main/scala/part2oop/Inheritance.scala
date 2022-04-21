package part2oop

object Inheritance extends App {
  // single class inheritance: you can only extend one class at a time
  class Animal {
    val creatureType = "wild"
    def eat(): Unit = println("nomnom")
  }

  class Cat extends Animal

  val cat = new Cat
  cat.eat()

  /**
   * protected methods can only be used by the class itself or subclasses
   *
   * class Person {
   *   protected def speaks(word: String): Unit = println(word)
   * }
   *
   * class Baby extends Person {
   *   def makesNoise(): Unit = speaks("gugu dada")
   * }
   *
   * but i can't call
   *
   * val john = new Baby
   * john.speaks("something")
   *
   * i can only call
   *
   * john.makesNoise()
   */

  /**
   * constructors
   * by extending Person, when creating a new Adult the JVM will call Person's constructor first
   */
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  /**
   * overriding
   */
  class Dog extends Animal {
    override val creatureType = "domestic"
    override def eat(): Unit = {
      super.eat()                     // super refers to the super class
      println("crunch crunch")
    }
  }

  val dog = new Dog
  dog.eat()
  println(dog.creatureType)

  /**
   * we could also override creatureType through Dog's constructor by writing
   *
   * class Dog(override val creatureType: String) extends Animal
   *
   * val dog = new Dog("K9")
   */

  // type substitution: polymorphism
  val unknownAnimal: Animal = new Dog

  /**
   * overRIDING vs overLOADING
   * overloading means many methods with the same name but different signatures
   */

  /**
   * preventing overrides
   *
   * 1. use keyword final on member
   * 2. use keyword final on the entire class
   * 3. seal the class using keyword sealed: you can extend classes in THIS FILE ONLY, but prevents extension in other files
   */
}
