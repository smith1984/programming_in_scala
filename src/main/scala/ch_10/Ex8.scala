package ch_10

object Ex8 {
  class Cat {
    val dangerous = false
  }

  class Tiger(override val dangerous : Boolean, private var age: Int) extends Cat {
  }

  class Tiger_(param1: Boolean, param2: Int) extends Cat {
    override val dangerous = param1
    private var age = param2
  }

  def main(args: Array[String]) {
    val tiger = new Tiger(true, 12)
    println("tiger [" + tiger + "]")
  }
}