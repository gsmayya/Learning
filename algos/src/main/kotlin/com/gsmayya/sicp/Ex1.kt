package com.gsmayya.sicp

fun helperForEx13(a: Int, b: Int): Int {
    return a * a + b * b
}

fun ex13(a: Int, b: Int, c: Int): Int {

    if (isMin(a, b, c)) { // a is the lowest
        return helperForEx13(b, c)
    } else if (isMin(a, b, c)) { // b is the lowest
        return helperForEx13(a, c)
    } else {
        return helperForEx13(a, b)
    }
}

fun main(args: Array<String>) {
    // println(ex13(1,2, 3))
    // println(ex13(2,1, 3))
    // println(ex13(2,3, 1))
    println(sqrtFun(4.0))
    println(cubeFun(8.0))
}