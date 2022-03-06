package part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"

  println(str)
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.endsWith("ala"))
  println(str.replace(",", "!"))
  println(str.toUpperCase())
  println(str.length)
  println(str.contains("am"))
  println(str.equalsIgnoreCase("HELLO, I AM LEARNING SCALa"))

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')

  println(str.reverse)
  println(str.take(5))

  // Scala-specific: string interpolators
  // S-interpolators
  val name = "Bia"
  val age = 1
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  val oneMoreGreeting = s"Hello, my name is $name and I am $age ${if (age > 1) "years" else "year"} old"
  println(anotherGreeting)
  println(oneMoreGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  /**
   * F-interpolators can also check for type correctness
   * val floatNumber = 11.1f
   * val anotherString = f"$floatNumber%3d"
   * won't compile because 3d format requires an Int, and not a Float
   */

  // Raw-interpolator
  println(s"This is a \n newline")
  println(raw"This is a \n newline")

  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
