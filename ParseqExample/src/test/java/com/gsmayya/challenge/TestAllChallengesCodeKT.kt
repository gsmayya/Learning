package com.gsmayya.challenge

import com.google.common.collect.Lists
import org.testng.Assert
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class TestAllChallengesCodeKT {

    fun getObject() : AllChallengesCodeKT {
        return AllChallengesCodeKT();
    }

    @DataProvider(name = "samples")
    private fun getSamples(): Array<Array<Any>> {
        return arrayOf(arrayOf<Any>("{[()]}", "YES"), arrayOf<Any>("{[(])}", "NO"),
                arrayOf<Any>("{{[[(())]]}}", "YES"))
    }

    @Test(dataProvider = "samples")
    fun testBalanced(input: String, output: String) {
        val resultValue = getObject().checkBalanced(input)
        Assert.assertEquals(resultValue, output)
    }


    @DataProvider(name = "sentences")
    private fun getSentences(): Array<Array<Any>> {
        return arrayOf(arrayOf<Any>("Pig latin is cool", "igPay atinlay siay oolcay"),
                arrayOf<Any>("Hello world !", "elloHay orldway !"))
    }

    @Test(dataProvider = "sentences")
    fun testPigLatin(sentence: String, converted: String) {
        val returnValue = getObject().simplePigLatin(sentence)
        Assert.assertNotNull(returnValue)
        Assert.assertEquals(returnValue, converted)
    }

    @DataProvider(name = "setOfLists")
    fun testDataSet(): Array<Array<Any>> {
        return arrayOf(arrayOf<Any>(Lists.newArrayList(1, 2, 3, 4, -1, -2, -3, -4), Lists.newArrayList(4, -10)),

                arrayOf<Any>(Lists.newArrayList(1, 2, -1), Lists.newArrayList(2, -1)),
                arrayOf<Any>(Lists.newArrayList(1, -1, -1), Lists.newArrayList(1, -2)),
                arrayOf<Any>(Lists.newArrayList(1, 1, -1, -2, -3, -4), Lists.newArrayList(2, -10)),
                arrayOf<Any>(Lists.newArrayList(-2, -3, -4), Lists.newArrayList(0, -9)),
                arrayOf<Any>(Lists.newArrayList(2, 3), Lists.newArrayList(2, 0)),
                arrayOf<Any>(Lists.newArrayList(0), Lists.newArrayList(0, 0))
                )
    }

    @Test(dataProvider = "setOfLists")
    fun testSumCount(listOfIntegers: List<Int>, resultValue: List<Int>) {
        val returnValue = getObject().getSumCount(listOfIntegers)
        org.junit.Assert.assertNotNull(returnValue)
        org.junit.Assert.assertArrayEquals(resultValue.toTypedArray(), returnValue.toTypedArray())
    }

    @DataProvider(name = "setOfWords")
    fun testDataSetForSpin(): Array<Array<Any>> {
        return arrayOf(arrayOf<Any>("Hey fellow warriors", "Hey wollef sroirraw"), arrayOf<Any>("This is a test", "This is a test"),
                arrayOf<Any>("This is another test", "This is rehtona test"))
    }

    @Test(dataProvider = "setOfWords")
    fun testSpinWords(words: String, reversed: String) {
        val returnValue = getObject().spinWords(words)
        Assert.assertNotNull(returnValue)
        Assert.assertEquals(returnValue, reversed)
    }


    @DataProvider(name = "sequences")
    fun testDataForFibonnaci(): Array<Array<Any>> {
        return arrayOf(arrayOf<Any>(14, 10L), arrayOf<Any>(35, 44L), arrayOf<Any>(5000, 3382L))
    }

    @Test(dataProvider = "sequences")
    fun testFiboEvenSum(limit: Int, sum: Long?) {
        val returnValue = getObject().sumOfEvenFibonacci(limit)
        Assert.assertNotNull(returnValue)
        Assert.assertEquals(returnValue, sum)
    }

}