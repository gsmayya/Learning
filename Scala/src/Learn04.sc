val times = 1

times match {
  case 1 => "One"
  case 2 => "Two"
  case _ => "Some other number"
}

times match {
  case i if i == 1 => "One"
  case i if i == 2 => "Two"
  case _ => "Some other number"
}

def bigger (o : Any): Any = {
  o match {
    case i: Int if i < 0 => i - 1
    case i: Int => i + 1
    case d: Double if d < 0.0 => d - 0.1
    case d: Double => d + 0.1
    case text: String => text + "s"
  }
}

bigger(10)
bigger(-10)
bigger(0.9)
bigger(-0.9)
bigger("Some")

case class Calculator(brand: String, model: String)

val hp20b = Calculator("hp", "20b")

//case classes automatically have equality and nice toString methods based on the constructor arguments.

val hp20B = Calculator("hp", "20b")

hp20b == hp20B

val hp30b = Calculator("hp", "30B")

def calcType(calc: Calculator) = calc match {
  case Calculator("hp", "20b") => "financial"
  case Calculator("hp", "48G") => "scientific"
  case Calculator("hp", "30B") => "business"
  case Calculator(ourBrand, ourModel) => "Calculator: %s %s is of unknown type".format(ourBrand, ourModel)
}

calcType(hp20b)

val cars = List("Mazda", "BMW", "Mercedes", "Bugati", "Honda", "Toyota")
cars groupBy { _.charAt(0) }

println("Partial functions")

val one : PartialFunction[Int, String] = { case 1 => "one"}
val two : PartialFunction[Int, String] = { case 2 => "two"}
val three : PartialFunction[Int, String] = { case 3 => "three"}
val four : PartialFunction[Int, String] = { case 4 => "four"}
val wildcard : PartialFunction[Int, String] = { case _ => "something else"}

val partial = one orElse two orElse three orElse four orElse wildcard

partial(1)
partial(4)
partial(9)