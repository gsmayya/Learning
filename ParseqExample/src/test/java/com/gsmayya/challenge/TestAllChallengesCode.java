package com.gsmayya.challenge;

import com.google.common.collect.Lists;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

// All the below tests classes with the problems defined in:
// https://dev.to/aspittel/daily-coding-puzzles-4ce9

public class TestAllChallengesCode {

    public AllChallengesCode getObject() {
        return new AllChallengesCode();
    }

    @DataProvider(name = "samples")
    private Object[][] getSamples() {
        return new Object[][]
                {
                        {"{[()]}", "YES"},
                        {"{[(])}", "NO"},
                        {"{{[[(())]]}}", "YES"}
                };
    }

    @Test(dataProvider = "samples")
    public void testBalanced(String input, String output) {
        String resultValue = getObject().checkBalanced(input);
        Assert.assertEquals(resultValue, output);
    }


    @DataProvider(name = "sentences")
    private Object[][] getSentences() {
        return new Object[][]
                {
                        {"Pig latin is cool", "igPay atinlay siay oolcay"},
                        {"Hello world !", "elloHay orldway !"}
                };
    }

    @Test(dataProvider = "sentences")
    public void testPigLatin(String sentence, String converted) {
        String returnValue = getObject().simplePigLatin(sentence);
        Assert.assertNotNull(returnValue);
        Assert.assertEquals(returnValue, converted);
    }

    @DataProvider(name = "setOfLists")
    public static Object[][] testDataSet() {
        return new Object[][] {
                {Lists.newArrayList(1,2,3,4, -1, -2, -3, -4) , Lists.newArrayList(4, -10)},
                {Lists.newArrayList(1,2, -1) , Lists.newArrayList(2, -1)},
                {Lists.newArrayList(1, -1, -1) , Lists.newArrayList(1, -2)},
                {Lists.newArrayList(1, 1, -1, -2, -3, -4) , Lists.newArrayList(2, -10)},
                {Lists.newArrayList(-2, -3, -4) , Lists.newArrayList(0, -9)},
                {Lists.newArrayList(2, 3) , Lists.newArrayList(2, 0)},
                {Lists.newArrayList(0), Lists.newArrayList(0, 0)},
                {null, Lists.newArrayList(0, 0) }
        };
    }

    @Test(dataProvider = "setOfLists")
    public void testSumCount(List<Integer> listOfIntegers, List<Integer> resultValue) {
        List<Integer> returnValue = getObject().getSumCount(listOfIntegers);
        org.junit.Assert.assertNotNull(returnValue);
        org.junit.Assert.assertArrayEquals(resultValue.toArray(), returnValue.toArray());
    }

    @DataProvider(name = "setOfWords")
    public static Object[][] testDataSetForSpin() {
        return new Object[][]
                {
                        {"Hey fellow warriors", "Hey wollef sroirraw"},
                        {"This is a test", "This is a test" },
                        {"This is another test", "This is rehtona test"}
                };
    }

    @Test(dataProvider = "setOfWords")
    public void testSpinWords(String words, String reversed) {
        String returnValue = getObject().spinWords(words);
        Assert.assertNotNull(returnValue);
        Assert.assertEquals(returnValue, reversed);
    }


    @DataProvider(name = "sequences")
    public static Object[][] testDataForFibonnaci() {
        return new Object[][] {
                {14, 10L},
                {35, 44L},
                {5000, 3382L}
        };
    }

    @Test(dataProvider = "sequences")
    public void testFiboEvenSum(Integer limit, Long sum) {
        Long returnValue = getObject().sumOfEvenFibonacci(limit);
        Assert.assertNotNull(returnValue);
        Assert.assertEquals(returnValue, sum);
    }


}
