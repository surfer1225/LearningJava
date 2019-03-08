package main.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ryan on 3/5/18.
 */

/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
 */

public class PermutationSeq {

    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];
        int[] numbers = new int[n];
        for(int i = 0 ; i < numbers.length ; i++) numbers[i] = i + 1;
        fact[0] = 1;
        for(int i = 1 ; i <= n ; i++) fact[i] = fact[i - 1] * i ;
        int current = n;
        int currentIndex = 0;
        while(k >= 0 && current > 0){
            int posIndex = (k - 1) / fact[(current - 1)];
            int temp = numbers[currentIndex + posIndex];
            if(posIndex != 0) {
                int j = currentIndex + posIndex - 1;
                while(j >= currentIndex){
                    numbers[j + 1] = numbers[j];
                    j--;
                }
                numbers[currentIndex] = temp;
                k -= posIndex * fact[(current - 1)];
            }

            --current;
            currentIndex++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : numbers) sb.append(i);
        return sb.toString();
    }

    /*
    public String getPermutation(int n, int k) {
        if (n==1) return "1";
        if (n==2) {
            if (k==2) return "21";
            else return "12";
        }
        String res = "";
        Map<Integer, Integer> m = new HashMap<>();
        int[] arr = new int[n];
        arr[0] = 1;
        // initialize the n! result
        for (int i=1;i<n;i++) {
            arr[i] = arr[i-1] * (i+1);
        }
        List<Integer> l = new ArrayList<>();
        for (int i=1;i<=n;i++) {
            m.put(arr[i-1], i);
            l.add(i);
        }
        while (k>0) {
            int temp = l.size() - 2;
            while (arr[temp]>k) {
                res+=l.remove(0);
                temp--;
            }
            if (m.containsKey(k)) {
                int lastN = m.get(k);
                while (l.size()>lastN) res+=l.remove(0);
                for (int i=0;i<lastN;i++) res+=l.remove(l.size()-1);
                return res;
            }
            int num = findNum(arr, k);
            if (k%num==0) {
                res+=l.remove(k/num-1);
                while (!l.isEmpty()) res+=l.remove(l.size()-1);
                return res;
            }
            res += l.remove(k / num);
            k -= (k / num) * num;
        }
        return res;
    }

    private int findNum(int[] arr, int k) {
        for (int i=0;i<arr.length-1;i++)
            if (arr[i+1]>k) return arr[i];
        return -1;
    }
    */

    public static void main(String[] args) {
        PermutationSeq p = new PermutationSeq();
        System.out.println(p.getPermutation(8, 31492));
        System.out.println(p.getPermutation(4, 9));
        System.out.println(p.getPermutation(3, 3));
    }
}
