package ch_12

class Frog  extends Animal with Philosophical with HasLegs {
  override def toString: String = "green"
  override def philosophize() = {
    println("It ain't easy being " + toString + "!")
}

