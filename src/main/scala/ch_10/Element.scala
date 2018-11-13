package ch_10

abstract class Element {
  def contents: Array[String]
  /*def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length*/
  val height: Int = contents.length
  val width: Int = if (height == 0) 0 else contents(0).length
}
