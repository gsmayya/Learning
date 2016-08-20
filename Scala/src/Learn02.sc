
// if I define val it becomes exposed, else private and I cannot access it
class Calculator (val brand: String) {
  /*
   A constructor
   */
  val color : String = if (brand == "TI") {
    "blue"
  } else if (brand == "HP") {
    "black"
  } else {
    "white"
  }

  def add(m:Int, n:Int): Int = m + n
}

val calc = new Calculator("HP")

calc.add(1, 2)

calc.color

calc.brand


class ScCalculator(override val brand: String) extends Calculator(brand:String) {
  def log(m: Double, base: Double) : Double = math.log(m) / math.log(base)
}

class EvScCalculator(override val brand: String) extends ScCalculator(brand:String) {
  def log(m: Double): Double = log(m, math.exp(1)) // math.exp(1) == e (2.7..)
}

abstract class Shape {
  def getArea() : Int
}

class Circle(r: Int) extends Shape {
  override def getArea(): Int = r * r * 3
}

val c = new Circle(2)

c.getArea()


trait Car {
  val brand: String
}

trait Shiny {
  val shineRefraction : Int
}

class BMW extends Car with Shiny {
  val brand = "BMW"
  val shineRefraction = 2
}


