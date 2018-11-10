package com.gsmayya.sicp

fun isMin(a: Int, b: Int, c: Int) : Boolean {
    return a < b && a < c;
}

fun average(x: Double, y: Double, z: Double) : Double {
    return (x + y) / z
}

fun improve(guess: Double, x: Double): Double {
    return average(guess, x/guess, 2.0)
}

fun improve3(guess: Double, x: Double): Double {
    return average(x/ (guess * guess), 2 * guess, 3.0)
}

fun goodEnough(guess: Double, x: Double): Boolean {
    return Math.abs(guess * guess - x) < 0.001
}

fun goodEnough3(guess: Double, x: Double): Boolean {
    return Math.abs(guess * guess * guess - x) < 0.001
}

fun iter(guess: Double, x: Double,
         improve: (Double, Double) -> Double,
         goodEnough: (Double, Double) -> Boolean) : Double {
    if (goodEnough(guess, x)) {
        return guess
    } else {
        return iter(improve(guess, x), x, improve, goodEnough)
    }
}

fun sqrtFun(x: Double): Double {
    return iter(1.0 , x, ::improve, ::goodEnough)
}

fun cubeFun(x: Double): Double {
    return iter(1.0, x, ::improve3, ::goodEnough3)
}
