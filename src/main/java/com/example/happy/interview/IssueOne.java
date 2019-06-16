package com.example.happy.interview;

import lombok.Data;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

//@Data
public class IssueOne {

    private BitSet bitSet;
    private Map<String, Integer> hashMap;

    public IssueOne() {
        this.bitSet = new BitSet();
        this.hashMap = new HashMap<>();
    }

    public static void main(String[] args) {
        IssueOne issueOne = new IssueOne();
        String input = "linux";
        //boolean result = issueOne.isUnique(input);
        boolean result = issueOne.isUniqueHash(input);
        System.out.println(result);

        for(int i = 0; i < issueOne.bitSet.length(); i ++) {
            System.out.println(issueOne.bitSet.get(i) + "--> " + i);
        }
    }

    /**
     * 使用BitSet
     * @param input
     * @return
     */
    public boolean isUnique(String input) {
        for(int i = 0; i < input.length(); i ++) {
            char ch= input.charAt(i);
            if(bitSet.get(ch)) {
                return false;
            }
            bitSet.set(ch);
        }
        return true;
    }

    /**
     * 使用HashMap
     * @param input
     * @return
     */
    public boolean isUniqueHash(String input) {

        String ch = "";
        for(int i = 0; i < input.length(); i ++) {
            ch = input.substring(i, i + 1);
            if(null != hashMap.get(ch)) {
                return false;
            }
            hashMap.put(ch, 1);
        }
        return true;
    }
}
