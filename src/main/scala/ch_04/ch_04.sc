/*class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}*/

object SemiInference {

  def printProd2() {
    val s = "hello"; println(s)
  }
  def check(x: Int) {
    if (x < 2)
      println("too small")
    else
      println("ok")
  }
}
SemiInference.printProd2()
SemiInference.check(-4)

class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte) = sum += b
  def checksum() = ~(sum & 0xFF) + 1
}

import scala.collection.mutable

object ChecksumAccumulator {

  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}

ChecksumAccumulator.calculate("Every value is an object.")
