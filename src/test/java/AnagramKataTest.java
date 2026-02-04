import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


import org.example.AnagramKata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnagramKataTest {
    private final AnagramKata anagramKata=new AnagramKata();



    private static void assertEntry(List<String> actual,String [] expected){
        assertEquals(actual.size(),expected.length,"Unexpected result size");
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.get(i),expected[i]);
        }
    }

    private static void assertEntries(List<List<String>> actual,String[][] expected){
        assertEquals(actual.size(),expected.length,"Unexpected result size");
        for (int i = 0; i < actual.size(); i++) {
            assertEntry(actual.get(i),expected[i]);
        }

    }
    @Test()
    @DisplayName("base example")
    void baseExample(){
        String[] strings ={"eat", "tea", "tan","ate","nat","bat"};
        String[][]expected={
                {"ate","eat","tea"},
                {"bat"},
                {"nat","tan"}
        };
        List<List<String>> result=anagramKata.groupAnagrams(Arrays.stream(strings).toList());
        assertEntries(result,expected);
    }
    @Test()
    @DisplayName("empty Array")
    void emptyArray(){
        String[] strings ={};
        String[][]expected={
        };
        List<List<String>> result=anagramKata.groupAnagrams(Arrays.stream(strings).toList());
        assertEntries(result,expected);
    }
    @Test()
    @DisplayName("only one word")
    void onlyOneWord(){
        String[] strings ={"abc"};
        String[][]expected={
                {"abc"},
        };
        List<List<String>> result=anagramKata.groupAnagrams(Arrays.stream(strings).toList());
        assertEntries(result,expected);
    }
    @Test()
    @DisplayName("All of them are anagrams")
    void allOfThemAreAnagrams(){
        String[] strings ={"bca","abc","cab","cba"};
        String[][]expected={
                {"abc", "bca", "cab", "cba"},
        };
        List<List<String>> result=anagramKata.groupAnagrams(Arrays.stream(strings).toList());
        assertEntries(result,expected);
    }
    @Test()
    @DisplayName("Including duplicates (preserved)")
    void includingDuplicatesPreserved(){
        String[] strings ={"ab", "ba", "ab", "abc", "bca"};
        String[][]expected={
                {"ab", "ab", "ba"},
                {"abc", "bca"}
        };
        List<List<String>> result=anagramKata.groupAnagrams(Arrays.stream(strings).toList());
        assertEntries(result,expected);
    }
    @Test
    @DisplayName("Groups whose sorting changes the global ordering.")
    void sortingChangesTheGlobalOrdering(){
        String[] strings ={"zzz", "zz", "b", "bb", "bba", "bab", "abb"};
        String[][]expected={
                {"abb", "bab", "bba"},
                {"b"},
                {"bb"},
                {"zz"},
                {"zzz"}
        };
        List<List<String>> result=anagramKata.groupAnagrams(Arrays.stream(strings).toList());
        assertEntries(result,expected);
    }





}
