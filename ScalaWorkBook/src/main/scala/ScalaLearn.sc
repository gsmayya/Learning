def sort(xs: Array[Int]): Unit = {

  def swap(i: Int, j: Int): Unit = {
    val t = xs(i)
    xs(i) = xs(j)
    xs(j) = t
  }

  def sort1(l: Int, r: Int): Unit = {
    val pivot = xs((l + r)/2)
    var i = l; var j = r
    while (i <= j) {
      while (xs(i) < pivot) i += 1
      while (xs(j) > pivot) j -= 1
      if (i <= j) {
        swap(i, j)
        i += 1
        j -= 1
      }
    }
    if (l < j) sort1(l, j)
    if (j < r) sort1(i, r)
  }
  sort1(0, xs.length - 1)
}

val a = Array(6,3,2,5,7,1,4,9)

sort(a)

a



def sort_new(xs: Array[Int]): Array[Int] = {
  if (xs.length <= 1) xs
  else {
    val pivot = xs(xs.length / 2)
    Array.concat(
      sort_new(xs filter (pivot >)),
      xs filter (pivot ==),
      sort_new(xs filter (pivot <)))
  }
}