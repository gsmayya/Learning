package com.gsmayya.challenge;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

// Code for https://dev.to/aspittel/daily-coding-puzzles-4ce9

public class AllChallengesCode {

    // Test sum count
    private int sum = 0;
    private int count = 0;

    private void compute(int val) {
        if (val > 0) {
            count++;
        } else {
            sum+=val;
        }
    }

    public List<Integer> getSumCount(List<Integer> integerList) {
        if (integerList == null || integerList.size() == 0) {
            return Lists.newArrayList(0, 0);
        }
        integerList.forEach(this::compute);
        return Lists.newArrayList(count, sum);
    }

    // Test Paranthesis check.

    private ImmutableMap<Character, Character> MAP_OF_SAME = ImmutableMap.of(
            '[', ']',
            '(', ')',
            '{', '}'
    );

    private Stack<Character> stack = new Stack<>();

    private void changeStack(Character c) {
        if (stack.empty()) {
            stack.push(c);
            return;
        }
        if (MAP_OF_SAME.get(stack.peek()) == c) {
            stack.pop();
        } else {
            stack.push(c);
        }
    }

    public String checkBalanced(String input) {
        input.chars()
                .forEach(c -> changeStack((char) c));
        return (stack.empty()) ? "YES": "NO";
    }

    // Simple Pig Latin
    private String convert(String str) {
        if (str.length() < 2) {
            if (str.matches("[!.,?;:]")) {
                return str;
            }
            return str + "ay";
        }
        return str.substring(1, str.length()) + str.substring(0, 1) + "ay";
    }

    public String simplePigLatin(String sentences) {
        List<String> listOfString = Arrays.stream(sentences.split("\\s"))
                .map(word -> convert(word))
                .collect(Collectors.toList());
        return String.join(" ", listOfString);
    }

    // SpinWords

    public String spinWords(String words) {
        List<String> listOfString = Arrays.stream(words.split("\\s"))
                .map(word -> checkAndDoSpin(word))
                .collect(Collectors.toList());

        return String.join(" ", listOfString);
    }

    private String checkAndDoSpin(String word) {
        return (word.length() < 5)? word : new StringBuffer(word).reverse().toString();
    }

    private List<Integer> getFibonnaci(Integer limit) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(1);
        sequence.add(2);
        while(true) {
            Integer nextAdd = sequence.get(sequence.size() - 2) + sequence.get(sequence.size() - 1);
            if (nextAdd > limit) {
                break;
            }
            sequence.add(nextAdd);
        }
        return sequence;
    }

    private Long evenSum = 0L;

    private void addToSum(Integer val) {
        if (val % 2 == 0) {
            evenSum += val;
        }
    }

    public Long sumOfEvenFibonacci(Integer limit) {
        getFibonnaci(limit).forEach(this::addToSum);
        return evenSum;
    }

}
