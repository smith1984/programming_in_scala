
def isEqual(x: Int, y: Int) = x == y
isEqual(421, 421)


def isEqual(x: Any, y: Any) = x == y
isEqual(421, 421)

val x = "abcd".substring(2)
val y = "abcd".substring(2)
x == y
x eq y
x ne y

class Dollars(val amount: Int) extends AnyVal {
  override def toString() = "$" + amount
}

val money = new Dollars(100)