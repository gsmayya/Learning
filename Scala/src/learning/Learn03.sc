class Foo {}

object FooMaker {
  def apply() = new Foo
}

val foo = FooMaker()

// Objects are used to hold single instances of a class. Often used for factories.

object Timer {
  var count = 0

  def currentCount() : Long = {
    count += 1
    count
  }
}

Timer.currentCount()
Timer.currentCount()
Timer.currentCount()
Timer.currentCount()

// read through about functions as objects

class AddOne extends (Int => Int) {
  def apply(m : Int) : Int = m + 1
}

val plusOne = new AddOne()
plusOne(4)

val numbers = Map("one" -> 1, "two" -> 2)

val n2 = numbers.get("two")
val n1 = numbers.get("three")

val result1 = n1.getOrElse(0) * 2
val result2 = n2.getOrElse(0) * 2

def squared(x : Int): Int = x * x

List(1,2,3) map squared


println("Traits")

class Animal {
  def printMe() { println("I'm an Animal!") }
}
trait Furry extends Animal {
  override def printMe() { println("I'm Furry!"); super.printMe() }
}

trait HasLegs extends Animal {
  override def printMe() { println("I have legs!"); super.printMe() }
}
trait FourLegged extends HasLegs {
  override def printMe() { println("I'm four-legged!"); super.printMe() }
}
// Multiple inheritance with the keyword "with"
class Cat extends Animal with Furry with FourLegged {
  override def printMe() { println("I'm a cat!"); super.printMe() }
}

new Cat().printMe()

