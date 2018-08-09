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

Misc.ifVariations(Array("foo"))
Misc.ifVariations(Array())
println("gcdLoop(2, 4) [" + Misc.gcdLoop(2, 4) + "]")
println("gcdLoop(3, 4) [" + Misc.gcdLoop(3, 4) + "]")
println("gcd(2, 4) [" + Misc.gcd(2, 4) + "]")
println("gcd(3, 4) [" + Misc.gcd(3, 4) + "]")
Misc.whileLoop()
Misc.shadowing()
Misc.shadowing2()

def greet() = { println("hi") }
() == greet()

val filesHere = (new java.io.File(".")).listFiles

def printFiles() {
  for (file <- filesHere)
    println(file)
}

def printFilesIter() {
  // Not common in Scala...
  for (i <- 0 to filesHere.length - 1)
    println(filesHere(i))
}

def printScalaFiles() {
  val filesHere = (new java.io.File(".")).listFiles

  for (file <- filesHere if file.getName.endsWith(".scala"))
    println(file)
}

def printScalaFiles2() {
  for (file <- filesHere)
    if (file.getName.endsWith(".scala"))
      println(file)
}

def printScalaFiles3() {
  for (
    file <- filesHere
    if file.isFile
    if file.getName.endsWith(".scala")
  ) println(file)
}

def fileLines(file: java.io.File) =
  scala.io.Source.fromFile(file).getLines().toList


def grepParens(pattern: String) {
  def grep(pattern: String) =
    for (
      file <- filesHere
      if file.getName.endsWith(".scala");
      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) println(file + ": " + line.trim)

  grep(pattern)
}

def grepGcd() {
  def grep(pattern: String) = grepParens(pattern)
  grep(".*gcd.*")
}

def grepGcd2() {
  def grep(pattern: String) =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(pattern)
    } println(file + ": " + trimmed)

  grep(".*gcd.*")
}

def scalaFiles =
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
  } yield file

val forLineLengths =
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(".*for.*")
  } yield trimmed.length

printFiles()
printFilesIter()
printScalaFiles()
printScalaFiles2()
printScalaFiles3()
grepParens(".*asdf.*")
grepGcd()
grepGcd2()
println("Files.scalaFiles.toList [" + scalaFiles.toList + "]")
println("Files.forLineLengths.toList [" + forLineLengths.toList + "]")

def throws1 {
  throw new IllegalArgumentException
}

def throws2(n: Int) = {
  val half =
    if (n % 2 == 0)
      n / 2
    else
      throw new RuntimeException("n must be even")
  half
}

def throws3 {
  import java.io.FileReader
  import java.io.FileNotFoundException
  import java.io.IOException

  try {
    val f = new FileReader("input.txt")
    // Use and close file
    println("f [" + f + "]")
  } catch {
    case ex: FileNotFoundException => // Handle missing file
      println("ex [" + ex + "]")
    case ex: IOException => // Handle other I/O error
      println("ex [" + ex + "]")
  }
}

def finally1 {
  import java.io.FileReader

  val file = new FileReader("input.txt")
  try {
    // Use the file
  } finally {
    file.close()  // Be sure to close the file
  }
}

import java.net.URL
import java.net.MalformedURLException

def urlFor(path: String) =
  try {
    new URL(path)
  } catch {
    case e: MalformedURLException =>
      new URL("http://www.scala-lang.org")
  }
def f(): Int = try return 1 finally return 2
def g(): Int = try 1 finally 2

try {
  throws1
} catch {
  case ex =>
    println("ex [" + ex + "]")
}

try {
  println("Exceptions.throws2(2) [" + throws2(2) + "]")
  throws2(3)
} catch {
  case ex =>
    println("ex [" + ex + "]")
}

throws3
println("Exceptions.urlFor(\"blah\") [" + urlFor("blah") + "]")
println("Exceptions.f [" + f + "]")
println("Exceptions.g [" + g + "]")

def match1(args: Array[String]) {
  val firstArg = if (args.length > 0) args(0) else ""

  firstArg match {
    case "salt" => println("pepper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("huh?")
  }
}

def match2(args: Array[String]) {
  val firstArg = if (!args.isEmpty) args(0) else ""

  val friend =
    firstArg match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "huh?"
    }

  println(friend)
}


match1(Array())
match1(Array("foo"))
match1(Array("eggs"))

match2(Array("chips"))

import scala.util.control.Breaks._
import java.io._

val in = new BufferedReader(new InputStreamReader(System.in))

breakable {
  while (true) {
    println("? ")
    if (in.readLine() == "") break
  }
}

def printMultiTable() = {

  var i = 1
  // only i in scope here

  while (i <= 10) {

    var j = 1
    // both i and j in scope here

    while (j <= 10) {

      val prod = (i * j).toString
      // i, j, and prod in scope here

      var k = prod.length
      // i, j, prod, and k in scope here

      while (k < 4) {
        print(" ")
        k += 1
      }

      print(prod)
      j += 1
    }

    // i and j still in scope; prod and k out of scope

    println()
    i += 1
  }

  // i still in scope; j, prod, and k out of scope
}

printMultiTable()

def makeRowSeq(row: Int) =
  for (col <- 1 to 10) yield {
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length)
    padding + prod
  }

// Returns a row as a string
def makeRow(row: Int) = makeRowSeq(row).mkString

// Returns table as a string with one row per line
def multiTable() = {

  val tableSeq = // a sequence of row strings
    for (row <- 1 to 10)
      yield makeRow(row)

  tableSeq.mkString("\n")
}

println("multiTable [" + multiTable + "]")