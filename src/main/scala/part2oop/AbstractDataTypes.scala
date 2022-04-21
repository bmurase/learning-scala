package part2oop

object AbstractDataTypes extends App {
  /**
   * abstract classes: contain unimplemented or abstract methods or fields
   */
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

  class Dog extends Animal {
    val creatureType: String = "canine"
    def eat(): Unit = println("crunch crunch")
  }

  /**
   * traits: have abstract fields and/or methods
   * but unlike abstract classes, they can be inherited along classes
   */
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"

    override def eat(): Unit = println("nomnomnom")
    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating a ${animal.creatureType}")
  }

  val croc = new Crocodile
  croc.eat(new Dog)
  croc.eat()

  /**
   * traits vs abstract classes
   * they both can have abstract and non-abstract members
   * but:
   * 1. traits do not have constructor parameters (this is now possible in Scala 3)
   * 2. multiple traits may be inherited by the same class, but multiple abstract classes may not be extended
   * 3. traits = behavior => we choose a trait over an abstract class if it describes a type of BEHAVIOR
   *    abstract class = someTHING, traits describe what that thing DO
   */
}
