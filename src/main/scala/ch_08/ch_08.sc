var increase = (x : Int) => x + 2
increase(10)

increase = (x : Int) => x + 999
increase(100)

increase = (x: Int) => {
    println("We")
    println("are")
    println("here!")
    x + 1}

increase(15)

val someNumbers = List(-11, -10, -5, 0, 5, 10)
someNumbers.foreach((x : Int) => println(x))
someNumbers.foreach(x => println(x))
someNumbers.foreach(println(_))
someNumbers.foreach(println _)
someNumbers.filter(_ > 0)

val f = (_: Int) + (_: Int)
f(5,17)

def sum(a: Int, b: Int, c: Int) = a + b + c
val a = sum _

val b = sum(1, _: Int, 3)
b(3)

someNumbers.foreach(println)

var more = 1
val addMore = (x : Int) => x + more
addMore(6)

more = 56
addMore(6)

var sum = 0
someNumbers.foreach(sum += _)

def makeIncreaser(more: Int) = (x: Int) => x + more

val inc1 = makeIncreaser(1)

val inc999 = makeIncreaser(999)