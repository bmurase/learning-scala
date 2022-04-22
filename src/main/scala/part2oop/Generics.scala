package part2oop

object Generics extends App {
  class MyList[A] {
    // use the type A
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // VARIANCE PROBLEM
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  /**
   * Q. does List[Cat] extends List[Animal]?
   * A. YES, that's called covariance
   */

  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  /**
   * but would that be ok? animalList.add(new Dog)
   * hard question, cause dogs are animals but what if the animal list is a cat list? answer at the end
   */

  /**
   * Q. does List[Cat] extends List[Animal]?
   * A. NO, that's called invariance
   */

  class InvariantList[A]
  // this wont work: val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  /**
   * Q. does List[Cat] extends List[Animal]?
   * A. HELL NO, that's called contravariance
   */

  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  /**
   * confusing, but what if we use another example?
   * an animal trainer can train a cat, since cat is an animal
   */

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // BOUNDED TYPES
  class Cage[A <: Animal](animal: A) // this cage only accepts subtypes of animal
  val cage = new Cage(new Dog)

  class Car
  // this wont work: val newCage = new Cage(new Car)

  class Cage2[A >: Animal](animal: A) // this cage only accepts super types of animal

  /**
   * bounded types can be helpful with covariance
   *
   * the code below wouldnt work, because we face the same question in line 36
   *
   * what if you want to add a dog to cat list? it would turn the cat list into a list of animals
   *
   * class MyCovariantList[+A] {
   *   def add(element: A): MyCovariantList[A] = ???
   * }
   *
   * so to avoid that, we could write:
   */

  class MyCovariantList[+A] {
    def add[B >: A](element: B): MyCovariantList[B] = ???

    /**
     * the method will take a parameter of type B, which will be a super type of type A
     * the element will be of type B and the method will return a list of B
     *
     * so if A = Cat and B = Dog
     * i have a list of cats and want to add a dog
     * since a dog is an animal, the list becomes a list of animals
     */
  }


}
