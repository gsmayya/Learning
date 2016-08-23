
def sqrt(x: Double) = {

  def abs(y : Double) = if (y < 0) -y else y

  def sqrIter(guess: Double): Double = {
    if (isGoodEnough(guess)) guess
    else sqrIter(improve(guess))
  }

  def isGoodEnough(guess: Double): Boolean = {
    abs(guess * guess - x) / x < 0.001
  }

  def improve(guess: Double): Double = {
    (guess + x / guess) / 2
  }

  sqrIter(1)
}

sqrt(2)
sqrt(1e-6)
sqrt(1e100)


val x = 0

def f(y: Int) = y + 1

val result = {
  val x = f(3)
  x * x
} + x


def gcd (a : Int, b : Int) : Int =
  if (b == 0) a
  else gcd (b , a % b)

gcd(14, 21)

def factorial(n: Int) : Int =
  if (n == 0) 1 else n * factorial(n - 1)

factorial(4)

def factorial2(n : Int) : Int = {
  def loop( acc: Int, n : Int) : Int =
    if (n ==0) acc
    else loop(acc * n, n - 1)
  loop(1, n)
}

factorial2(4)
