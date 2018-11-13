package ch_10

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override val width = s.length
  override val height = 1
}