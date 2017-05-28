/**
 * Created by gsmayya on 5/27/17.
 */

fun main(args: Array<String>) {

    val x1: Vector = Vector(arrayListOf(8.218, -9.341))
    val x2: Vector = Vector(arrayListOf(-1.129, 2.111))
    println(x1.sum(x2))

    val x3: Vector = Vector(arrayListOf(7.119, 8.215))
    val x4: Vector = Vector(arrayListOf(-8.223, 0.878))
    println(x3.diff(x4))

    val x5: Vector = Vector(arrayListOf(1.671, -1.012, -0.318))
    println(x5.scalar(7.41))

    val x6 : Vector = Vector(arrayListOf(-0.221, 7.437))
    println(x6.maginitude())
    println(x6.direction())
    val x7 : Vector = Vector(arrayListOf(8.813, -1.331, -6.247))
    println(x7.maginitude())
    println(x7.direction())


    val x8 : Vector = Vector(arrayListOf(5.581, -2.136))
    println(x8.maginitude())
    println(x8.direction())
    val x9 : Vector = Vector(arrayListOf(1.996, 3.108, -4.554))
    println(x9.maginitude())
    println(x9.direction())
}
