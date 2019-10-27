package main.java.Company.Facebook;

import java.util.HashMap;
import java.util.Map;

/*
340. Longest Substring with At Most K Distinct Characters

Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
 */
public class LongestSubstringWithKDistinctChars {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> charCnt = new HashMap<>();

        int i=0,j=0,max=0;

        while (j<s.length()) {
            char c = s.charAt(j);
            charCnt.put(c,charCnt.getOrDefault(c,-1)+1);

            while (charCnt.size() > k) {
                if (charCnt.get(s.charAt(i))==0) charCnt.remove(s.charAt(i));
                else charCnt.put(s.charAt(i),charCnt.get(s.charAt(i))-1);
                ++i;
            }
            max = Math.max(j-i+1,max);
            ++j;
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithKDistinctChars lc = new LongestSubstringWithKDistinctChars();
        System.out.println(lc.lengthOfLongestSubstringKDistinct("aa",1));
        System.out.println(lc.lengthOfLongestSubstringKDistinct("eceba",2));
    }
}

/*
class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int n = s.length();
    if (n*k == 0) return 0;

    // sliding window left and right pointers
    int left = 0;
    int right = 0;
    // hashmap character -> its rightmost position
    // in the sliding window
    HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

    int max_len = 1;

    while (right < n) {
      // add new character and move right pointer
      hashmap.put(s.charAt(right), right++);

      // slidewindow contains 3 characters
      if (hashmap.size() == k + 1) {
        // delete the leftmost character
        int del_idx = Collections.min(hashmap.values());
        hashmap.remove(s.charAt(del_idx));
        // move left pointer of the slidewindow
        left = del_idx + 1;
      }

      max_len = Math.max(max_len, right - left);
    }
    return max_len;
  }
}
 */

/*
Complexity Analysis

Do we have here the best possible time complexity \mathcal{O}(N)O(N) as it was for more simple problem with at most two distinct characters?

For the best case when input string contains not more than k distinct characters the answer is yes. It's the only one pass along the string with N characters and the time complexity is \mathcal{O}(N)O(N).

For the worst case when the input string contains n distinct characters, the answer is no. In that case at each step one uses \mathcal{O}(k)O(k) time to find a minimum value in the hashmap with k elements and so the overall time complexity is \mathcal{O}(N k)O(Nk).

Time complexity : \mathcal{O}(N)O(N) in the best case of k distinct characters in the string and \mathcal{O}(N k)O(Nk) in the worst case of N distinct characters in the string.

Space complexity : \mathcal{O}(k)O(k) since additional space is used only for a hashmap with at most k + 1 elements.


Approach 2: Sliding Window + Ordered Dictionary.
How to achieve \mathcal{O}(N)O(N) time complexity

Approach 1 with a standard hashmap couldn't ensure \mathcal{O}(N)O(N) time complexity.

To have \mathcal{O}(N)O(N) algorithm performance, one would need a structure, which provides four operations in \mathcal{O}(1)O(1) time :

Insert the key

Get the key / Check if the key exists

Delete the key

Return the first / or the last added key/value

The first three operations in \mathcal{O}(1)O(1) time are provided by the standard hashmap, and the forth one - by linked list.

There is a structure called ordered dictionary, it combines behind both hashmap and linked list. In Python this structure is called OrderedDict and in Java LinkedHashMap.

Ordered dictionary is quite popular for the interviews, for example, check to implement LRU cache question by Google.

Algorithm

Let's use ordered dictionary instead of standard hashmap to trim the algorithm from the approach 1 :

Return 0 if the string is empty or k is equal to zero.
Set both set pointers in the beginning of the string left = 0 and right = 0 and init max substring length max_len = 1.
While right pointer is less than N:
If the current character s[right] is already in the ordered dictionary hashmap -- delete it, to ensure that the first key in hashmap is the leftmost character.
Add the current character s[right] in the ordered dictionary and move right pointer to the right.
If ordered dictionary hashmap contains k + 1 distinct characters, remove the leftmost one and move the left pointer so that sliding window contains again k distinct characters only.
Update max_len.
 */
/*
class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int n = s.length();
    if (n*k == 0) return 0;

    // sliding window left and right pointers
    int left = 0;
    int right = 0;
    // hashmap character -> its rightmost position
    // in the sliding window
    LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<Character, Integer>(k + 1);

    int max_len = 1;

    while (right < n) {
      Character character = s.charAt(right);
      // if character is already in the hashmap -
      // delete it, so that after insert it becomes
      // the rightmost element in the hashmap
      if (hashmap.containsKey(character))
        hashmap.remove(character);
      hashmap.put(character, right++);

      // slidewindow contains k + 1 characters
      if (hashmap.size() == k + 1) {
        // delete the leftmost character
        Map.Entry<Character, Integer> leftmost = hashmap.entrySet().iterator().next();
        hashmap.remove(leftmost.getKey());
        // move left pointer of the slidewindow
        left = leftmost.getValue() + 1;
      }

      max_len = Math.max(max_len, right - left);
    }
    return max_len;
  }
}
 */
