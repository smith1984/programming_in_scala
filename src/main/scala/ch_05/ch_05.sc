val hex = 0x5
val hex2 = 0x00FF
val magic = 0xcafebabe

val dec1 = 31
val dec2 = 255
val dec3 = 20

val prog = 0XCAFEBABEL
val tower = 35L
val of = 31l

val little: Short = 367
val littler: Byte = 38

val big = 1.2345
val bigger = 1.2345e1
val biggerStill = 123E45

val littlef = 1.2345F
val littleBigger = 3e5f

val anotherDouble = 3e5
val yetAnother = 3e5D

val a = 'A'
val d = '\u0041'
val f = '\u0044'
//val B\u0041\u0044 = 1
val backslash = '\\'

val hello = "hello"
val escapes = "\\\"\'"

println("""Welcome to Ultamix 3000.
           Type "HELP" for help.""")

println("""|Welcome to Ultamix 3000.
           |Type "HELP" for help.""".stripMargin)

val s_ = 'aSymbol
val nm = s_.name

val bool = true
val fool = false

val name = "reader"
println(s"Hello, $name!")

s"The answer is ${6 * 7}."
println(raw"No\\\\escape!")
f"${math.Pi}%.5f"
val pi = "Pi"
f"$pi is approximately ${math.Pi}%.8f."
val sum = 1 + 2 // Scala вызывает 1.+(2)
val sumMore = 1.+(2)
val longSum = 1 + 2L

val s = "Hello, world!"
s indexOf 'o'
s indexOf ('o', 5)
-2.0
(2.0).unary_-
s.toLowerCase
s toLowerCase

math.IEEEremainder(11.0, 4.0)
11.0%4.0
val neg = 1 + -3
val y = +3
-neg

val toBe = true
val question = toBe || !toBe
val paradox = toBe && !toBe

def salt() = { println("salt"); false }
def pepper() = { println("pepper"); true }
pepper() && salt()
salt() && pepper()
salt() & pepper()

1 & 2
1 | 2
1 ^ 3
~1
-1 >> 31
-1 >>> 31

1 == 2
1 != 2
2 == 2
List(1, 2, 3) == List(1, 2, 3)
List(1, 2, 3) == List(4, 5, 6)
1 == 1.0
List(1, 2, 3) == "hello"
List(1, 2, 3) == null
null == List(1, 2, 3)
("he" + "llo") == "hello"

2 << 2 + 2
2 + 2 << 2