/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
*/

import java.util.HashMap;

public class A76_MinimumWindowString{
    public static String minWindow(String s, String t) {
        
        //edge cases
        if(s == null || t == null || s.length() < t.length() || t.length() == 0 || s.equals("")){
            return "";
        }
        
        //setup memory to save solution as we search through string
        int minLeft = 0;
        int minRight = 0;
        int minLength = s.length() + 1;
        int count = t.length();
        
        //a key/val pair of 'p', 3 means we need 3 more 'p's to form t
        //a key/val pair of 't', -2 means we have two excess 't's we can afford to lose
        HashMap<Character, Integer> charsNeeded = new HashMap<>();
        for(char c : t.toCharArray()){
            charsNeeded.put(c, charsNeeded.getOrDefault(c, 0) + 1);
        }
        
        //set up sliding window
        int left = 0;
        int right = 0;
        
        while(right < s.length()){
            
            char c = s.charAt(right);
            if(charsNeeded.containsKey(c)){
                charsNeeded.put(c, charsNeeded.get(c) - 1);
                if(charsNeeded.get(c) >= 0){
                    count--;
                }
            }

            while(count == 0 && left <= right){
                
                int len = right - left + 1;
                if(len < minLength){
                    minLength = len;
                    minLeft = left;
                    minRight = right;
                }
                
                
                char leftC = s.charAt(left);
                if(charsNeeded.containsKey(leftC)){
                    charsNeeded.put(leftC, charsNeeded.get(leftC) + 1);
                    if(charsNeeded.get(leftC) > 0){
                        count++;
                    }
                }
                left++;
            }
            right++;
        }
        
        //no solution found
        if(minLength == s.length() + 1){
            return "";
        }
        
        return s.substring(minLeft, minRight + 1);
    }

    public static void test(){
        System.out.println(minWindow("aa", "aa"));
    }
}