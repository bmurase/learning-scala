package part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 5
  println(x)

  val aString: String = "hello"
  val anotherString = "goodbye"
  println(aString + " " + anotherString)

  val aBoolean: Boolean = false
  val aChar: Char = 'c'
  val anInt: Int = x
  val aShort: Short = 9999
  val aLong: Long = 999999999999999999L
  val aFloat: Float = 2.0f
  val aDouble: Double = 31.5

  var aVariable: Int = 4
  println(aVariable)
  aVariable = 5
  println(aVariable)
}
