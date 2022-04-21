package bootcamp

object Bootcamp extends App {
  var bar: String =
    """
      |oxe
      |o que rolou aqui
      |""".stripMargin

  println(bar)

  /**
   * Unit acho que vira Object no bytecode do Java (talvez seja void)
   */
}
