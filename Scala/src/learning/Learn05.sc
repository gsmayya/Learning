val l = List(List("one","two","three"), List("Apple","Orange","Pear"), List("Apple","Intel","Microsoft"))
val l1 = List("one", "two", "three")
val l2 = List("a", "b", "c")

l.head

println("Problem  3 of Hands on")
List(l.head.head, l.tail.head, l.tail.tail.head)


println("for loops")
val res81 = for { x <- l1; y <- l2} (x, y)

val res87 = List(for { x <- l1; y <- l2} (x, y))

println("Learning yields")
val res90 = List(for { x <- l1; y <- l2} yield (x,y))

val res93 = for { x <- l1; y <- l2} yield (x,y)

def foo(n: Int, v: Int) =
  for (i <- 0 until n; j <- 0 until n if i + j == v) yield Pair(i, j);

foo(20,32)
foo(10,10)
foo(10,10) foreach { case (i, j) => println("$i, $j") }
foo(10,10) foreach { case (i, j) => println(s"$i, $j") }
foo(20,32) foreach { case (i, j) => println(s"$i, $j") }
l
l.map( t => t.head)

println("Generating with a condition")
for (ls <- l if ls.head == "Apple") yield ls

(for (ls <- l if ls.head == "Apple") yield ls).map(t => t.head)

println("Cartesian product")
for(x <- l1 ; y <- l2) yield (x, y)

println("Case class")
case class Tree(x: Int, children: List[Tree])
val tree = Tree(1,List(Tree(2,Nil),Tree(3,List(Tree(4,Nil),Tree(5,Nil)))))
tree
List(tree)
var nodes = List(tree)
nodes = nodes.flatMap(_.children)
nodes
nodes = nodes.flatMap(_.children)
l1 zip l2

l1.flatMap(pre => l2.map((pre, _)))
val numb = List.range(1,10)
numb.partition(_ % 2 == 0)

numb.foldLeft(0)((m:Int, n:Int) => m + n)

numb.foldLeft(0){ (m: Int, n: Int) => println("m: " + m + " n: " + n); m + n }

numb.foldRight(0) { (m: Int, n: Int) => println("m: " + m + " n: " + n); m + n }

val k = List (2)
3 :: k

k

def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
  numbers.foldRight(List[Int]()) { (x: Int, xs: List[Int]) =>
    fn(x) :: xs
  }
}

val timesTwo = {(x:Int) => x * 2}

ourMap(numb, timesTwo(_))

val extensions = Map("steve" -> 100, "bob" -> 101, "joe" -> 201)

extensions.filter((np : (String, Int)) => np._2 < 200)

//anon function

val anon = { (i:Int ) =>
  println("Hello world")
  i * 3
}

anon(5)

def adder(m:Int, n:Int) = m + n

// assign new variable with partially applied, as in this first parameter.
def add2 = adder(2, _:Int)

add2(5)

def multiply(m:Int)(n:Int) = m * n

multiply(2)(3)

val tTwo = multiply(2) _

tTwo(5)

val curriedAdd = (adder _).curried

val addTwo = curriedAdd(2)

addTwo(5)


def capitalizeAll(args : String*) = {
  args.map {
    arg => arg.capitalize
  }
}

capitalizeAll("hello", "world")
