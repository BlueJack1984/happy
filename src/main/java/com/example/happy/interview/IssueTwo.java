package com.example.happy.interview;


import java.util.HashMap;
import java.util.Map;

public class IssueTwo {

    private Map<String, Integer> firstHashMap;
    private Map<String, Integer> secondHashMap;

    public IssueTwo() {
        this.firstHashMap = new HashMap<>();
        this.secondHashMap = new HashMap<>();
    }

    public static void main(String[] args) {

    }

    public boolean isPermutation(String first, String second) {
        if(first == null || second == null) {
            return false;
        }
        if(first.length() != second.length()) {
            return false;
        }
        for(int i = 0; i < first.length(); i ++) {
            String ch = first.substring(i, i + 1);

        }
        for(int i = 0; i < second.length(); i ++) {

        }
        return true;
    }
}
