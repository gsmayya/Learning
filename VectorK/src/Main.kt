import math.Vector

/**
 * Created by gsmayya on 5/27/17.
 */

fun main(args: Array<String>) {

    val x1: Vector = Vector(arrayListOf(1.0, 2.0, -1.0))
    val x2: Vector = Vector(arrayListOf(3.0,1.0, 0.0))
    println(x1.dot(x2))

    val k = readLine()!!.toInt()
    println(k)
}
