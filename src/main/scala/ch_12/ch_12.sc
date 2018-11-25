trait Philosophical {
  def philosophize() = {
    println("I consume memory, therefore I am!")
  }
}

class Frog extends Philosophical {
  override def toString: String = "green"
}

val frog = new Frog
frog.philosophize()

var phil: Philosophical = frog
phil.philosophize()

class Animal {}

trait HasLegs {}

class Frog_new extends Animal with Philosophical with HasLegs {
  override def toString: String = "new green"

  override def philosophize() = {
    println("It ain't easy being " + toString + "!")
  }
}

val frog_new = new Frog_new
phil = frog_new
frog_new.philosophize()
phil.philosophize()