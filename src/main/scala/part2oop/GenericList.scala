package part2oop

abstract class GenericList[+A] {
  /**
   * list of integers
   * head = returns first element of the list
   * tail = returns the remainder of the list
   * isEmpty = is this list empty
   * add(int) => new list with this element added
   * toString => a string representation of the list
   */

  def head: A
  def tail: GenericList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): GenericList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object GenericEmpty extends GenericList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: GenericList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): GenericList[B] = new GenericCons(element, GenericEmpty)
  def printElements: String = ""
}

class GenericCons[+A](h: A, t: GenericList[A]) extends GenericList[A] {
  def head: A = h
  def tail: GenericList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): GenericList[B] = new GenericCons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h.toString + " " + t.printElements
}

object GenericListTest extends App {
  val listOfIntegers: GenericList[Int] = new GenericCons(1, new GenericCons(2, new GenericCons(3, GenericEmpty)))
  val listOfStrings: GenericList[String] = new GenericCons("Hello", new GenericCons("Scala", GenericEmpty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}