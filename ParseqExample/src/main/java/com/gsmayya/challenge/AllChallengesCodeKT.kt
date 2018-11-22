package com.gsmayya.challenge

import com.google.common.collect.ImmutableMap
import com.google.common.collect.Lists
import java.util.*
import java.util.function.Consumer
import java.util.stream.Collectors

class AllChallengesCodeKT {

    private var sum: Int = 0
    private var count: Int = 0

    private fun compute(value: Int) {
        if (value > 0) {
            count++
        } else {
            sum += value;
        }
    }

    fun getSumCount(integerList: List<Int>?): List<Int> {

        if( integerList == null || integerList.isEmpty()) {
            return Lists.newArrayList(0, 0)
        }
        integerList.forEach(Consumer<Int> { this.compute(it) })
        return Lists.newArrayList(count, sum)
    }


    private val MAP_OF_SAME = ImmutableMap.of(
            '[', ']',
            '(', ')',
            '{', '}'
    )

    private val stack = Stack<Char>()

    private fun changeStack(c: Char?) {
        if (stack.empty()) {
            stack.push(c)
            return
        }
        if (MAP_OF_SAME.get(stack.peek()) === c) {
            stack.pop()
        } else {
            stack.push(c)
        }
    }

    fun checkBalanced(input: String): String {
        input.chars()
                .forEach { c -> changeStack(c.toChar()) }
        return if (stack.empty()) "YES" else "NO"
    }

    private fun convert(str: String): String {
        return if (str.length < 2) {
            if (str.matches("[!.,?;:]".toRegex())) {
                str
            } else str + "ay"
        } else str.substring(1, str.length) + str.substring(0, 1) + "ay"
    }

    fun simplePigLatin(sentences: String): String {
        val listOfString = Arrays.stream(sentences.split("\\s".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
                .map { word -> convert(word) }
        return listOfString.toArray().joinToString(" ")
    }


    fun spinWords(words: String): String {
        val listOfString = Arrays.stream(words.split("\\s".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
                .map { word -> checkAndDoSpin(word) }

        return listOfString.toArray().joinToString(" ")
    }

    private fun checkAndDoSpin(word: String): String {
        return if (word.length < 5) word else StringBuffer(word).reverse().toString()
    }

    private fun getFibonnaci(limit: Int): List<Int> {
        val sequence = ArrayList<Int>()
        sequence.add(1)
        sequence.add(2)
        while (true) {
            val nextAdd = sequence[sequence.size - 2] + sequence[sequence.size - 1]
            if (nextAdd > limit) {
                break
            }
            sequence.add(nextAdd)
        }
        return sequence
    }

    private var evenSum: Long = 0L

    private fun addToSum(`val`: Int?) {
        if (`val`!! % 2 == 0) {
            evenSum += `val`.toLong()
        }
    }

    fun sumOfEvenFibonacci(limit: Int): Long? {
        getFibonnaci(limit).forEach(Consumer { this.addToSum(it) })
        return evenSum
    }

}