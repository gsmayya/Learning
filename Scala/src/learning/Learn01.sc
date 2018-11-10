println("Using java functions")
s"The time of is ${new java.util.Date()}"
val m =  Map("quick" -> List(1,2,3), "fox" -> List(1,2,3));
m
def addThree(x:Int) = {
  x + 3
}

addThree(4)

def sayHi:Unit = { println("Hi") }

sayHi

println("Using default arguments")
def hi(first:String = "Guru", second:String = "See") = { println(s"$first $second") }
hi()
hi(second="Seetharama")
hi(second="Seetharama", first="Gururaj")

println("Using variable number of arguments")
//variable number of arguments.
def addThem(nums:Int*) = nums.sum

addThem(1,2,3,4)

println("Function composition")
def addExWhy(x:Int)(y:Int) = x + y
addExWhy(2)(3)

def addFive = addExWhy(5)_

addFive(4)

println("Anonymous functions")

{(x:Int) =>  x * 2}

({(x:Int) =>  x * 2})(5)

val timesTwo = {(x:Int) => x * 2}

timesTwo(2)

timesTwo(5)

println("usage of apply method")
object timesSix {
  def apply(x:Int):Int = x * 6
}
timesSix.apply(4)
timesSix(5)

println("pass by value and pass by reference using := to pass by value")
def f(time: => Long) {
  println(s"time1 is $time")
  Thread.sleep(100)
  println(s"time2 is $time")
}

f(new java.util.Date().getTime)

println("Closure")
def cube(x:Int) = {
  def timesX(y:Int) = x * y
  timesX(x*x)
}

cube(3)

val t1:(Int, String) = (2, "yes")

println("using update method, which can be used, applied to update some values")
object Foo {
  def update(x:Int, y:String) = println(s"Updating $x for $y")
}

Foo(2) = "Four"

1::List(2,3)

println("List compositions")

List(3,4) ++ List(5,6)


