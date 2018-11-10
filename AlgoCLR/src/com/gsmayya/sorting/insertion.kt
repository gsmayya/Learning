package com.gsmayya.sorting

import java.util.*

object InsertionSort {
    fun sort(arr: MutableList<Int>) {
        for (j in 1 until arr.size) {
            val key = arr[j]
            var i = j - 1
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i]
                i -= 1
            }
            arr[i + 1] = key
            println(arr)
        }
    }
}


object MergeSort {

    fun merge(arr:MutableList<Int>, p:Int, q:Int, r:Int) {

    }

    fun sort(arr:MutableList<Int>) {

    }
}

fun main(args: Array<String>) {
    val arr: MutableList<Int> = mutableListOf()
    for (i in 1..20) {
        arr.add(rand(i, 1500))
    }
    InsertionSort.sort(arr)
}

fun rand(from: Int, to: Int): Int {
    val random = Random()
    return random.nextInt(to - from) + from
}