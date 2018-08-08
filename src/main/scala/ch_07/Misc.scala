package ch_07

object Misc {
  var loopcounter = 2

  def ifVariations(args: Array[String]) {
    println("args [" + args.toList + "]")

    {
      var filename = "default.txt"
      if (!args.isEmpty)
        filename = args(0)
      println("filename [" + filename + "]")
    }

    {
      val filename =
        if (!args.isEmpty) args(0)
        else "default.txt"
      println("filename [" + filename + "]")
    }

    println(if (!args.isEmpty) args(0) else "default.txt")
  }

  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    b
  }

  def gcd(x: Long, y: Long): Long =
    if (y == 0) x else gcd(y, x % y)

  def whileLoop() {
    def readLine() = {
      if (loopcounter > 0) {
        loopcounter -= 1
        "a line"
      } else
        ""
    }

    var line = ""
    do {
      line = readLine()
      println("Read: " + line)
    } while (line != "")
  }

  def shadowing() {
    val a = 1;
    {
      val a = 2 // Compiles just fine
      println(a)
    }
    println(a)
  }

  def shadowing2() {
    val a = 1;
    {
      val a = 2;
      {
        println(a)
      }
    }
  }
}