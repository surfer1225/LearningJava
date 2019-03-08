package main.java.BasicAlgo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Ryan on 20/12/17.
 */

/*
Simulate n choose r
 */
public class AllCombiFromSet {

    Set<Set<Integer>> results = new HashSet<>();

    public void printCombi(int[] arr, int r) {
        //commmented out
        //combiUtil(arr, new int[arr.length], 0, arr.length-1, 0, r);
        List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(l);
        combiUtilPascal(l, r, new HashSet<>());

        for (Set<Integer> s:results) {
            for (Integer i:s) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /*
    arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed
    */
    private void combiUtil(int[] arr, int[] data, int start, int end, int index, int r) {
        if (index==r) {
            for (int i=0;i<r;i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
        else {
            // replace index with all possible elements. The condition
            // "end-i+1 >= r-index" makes sure that including one element
            // at index will make a combination with remaining elements
            // at remaining positions
            for (int i=start;i<end&&end-i+1>=r-index;i++) {
                data[index]=arr[i];
                combiUtil(arr,data,i+1,end,index+1,r);
            }
        }
    }

    private void combiUtilPascal(List<Integer> temp, int r, Set<Integer> res) {
        if (res.size()==r) {
            /*
            System.out.print("result found: ");
            for (int i:res) {
                System.out.print(i + " ");
            }
            System.out.println();
            */
            results.add(res);
        }
        else {
            for (Integer i : temp) {
                List<Integer> list = new ArrayList<>(temp);
                list.remove(i);
                // not counting the removed element
                combiUtilPascal(new ArrayList<>(list), r, new HashSet<>(res));
                // counting the removed element
                res.add(i);
                combiUtilPascal(new ArrayList<>(list), r, new HashSet<>(res));
            }
        }
    }

    public static void main(String[] args) {
        AllCombiFromSet combi = new AllCombiFromSet();
        combi.printCombi(new int[]{3,2,1,4,5},3);
    }
}
