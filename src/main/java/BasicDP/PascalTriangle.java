package main.java.BasicDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ryan on 25/12/17.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows==0) return res;
        List<Integer> first = new LinkedList<Integer>(Arrays.asList(new Integer[]{1}));
        res.add(first);
        if (numRows==1) return res;
        List<Integer> second = new LinkedList<Integer>(Arrays.asList(new Integer[]{1,1}));
        res.add(second);
        if (numRows==2) return res;
        List<Integer> prev = new ArrayList<>(second);
        for (int i=2;i<numRows;i++) {
            List<Integer> temp = new LinkedList<>();
            temp.add(1);
            for (int j=1;j<prev.size();j++) {
                temp.add(prev.get(j)+prev.get(j-1));
            }
            temp.add(1);
            res.add(temp);
            prev = new ArrayList<>(temp);
        }
        return res;
    }
}
