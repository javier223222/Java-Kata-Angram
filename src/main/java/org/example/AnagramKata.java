package org.example;

import java.util.*;

public class AnagramKata {
    public List<List<String>> groupAnagrams(List<String> words){
        if (words==null)throw new IllegalArgumentException();
        Map<String,List<String>> signatureWords=new HashMap<>();
        List<List<String>> anagrams=new ArrayList<>();
        words.forEach(s -> {
            char[] tempArray=s.toLowerCase().toCharArray();
            Arrays.sort(tempArray);
            signatureWords.put(new String(tempArray),new ArrayList<>());
        });
        for (String i:signatureWords.keySet()) {
            for (String word:words){
                char[] tempArray=word.toLowerCase().toCharArray();
                Arrays.sort(tempArray);
                if (new String(tempArray).equals(i)){
                    signatureWords.get(i).add(word);
                }
            }
            anagrams.add(signatureWords.get(i));
        }
        return anagrams.stream().map(l->l.stream().sorted(Comparator.comparing(String::toString)).toList()).sorted(Comparator.comparing(l->l.get(0))).toList();
    }
}
