package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
     AnagramKata anagramKata=new AnagramKata();
     String[][]inputs={
             {"eat", "tea", "tan", "ate", "nat", "bat"},
             {},
             {"abc"},
             {"dog", "cat", "bird"},
             {"bca", "abc", "cab", "cba"},
             {"ab", "ba", "ab", "abc", "bca"},
             {"zzz", "zz", "b", "bb", "bba", "bab", "abb"}
     };
     for (String[] input : inputs) {
            List<List<String>> result = anagramKata.groupAnagrams(Arrays.stream(input).toList());
            result.forEach(l -> System.out.println(l.toString()));
            System.out.println();
     }
    }
}