def containsNeg(nums: List[Int]): Boolean = {
  var exists = false
  for (num <- nums)
    if (num < 0)
      exists = true
  exists
}
containsNeg(List(1, 2, 3, 4))
containsNeg(List(1, -2, -3, 4))

def containsNeg2(nums: List[Int]) = nums.exists(_ < 0)

containsNeg2(Nil)
containsNeg2(List(1, -2, -3, 4))

/*def containsOdd(nums: List[Int]): Boolean = {
  var exists = false
  for (num <- nums)
    if (num % 2 == 1)
      exists = true
  exists
}*/

def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)

containsOdd(List(1, -2, -3, 4))

def plainOldSum(x: Int, y: Int) = x + y
plainOldSum(2, 3)
def curriedSum(x: Int)(y: Int) = x + y
curriedSum(2)(3)

def first(x: Int) = (y: Int) => x + y

val second = first(2)

second(3)
val onePlus = curriedSum(1) _
onePlus(3)

val twoPlus = curriedSum(2) _

twoPlus(3)

def twice (op : Double => Double, x: Double) = op(op(x))

twice (_ + 1, 5)

