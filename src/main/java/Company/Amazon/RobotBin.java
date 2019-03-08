package main.java.Company.Amazon;


import java.util.LinkedList;
import java.util.List;

/*
How many times will a robot need to retrieve bins if it is given an array of bin ID's and
it can only hold N bins at a time? When the robot is already holding N bins,
it will return the least recently retrieved bin and store the new bin.
 */
public class RobotBin {
    public int binCount(int[] array, int size) {
        if (array == null) return 0;
        List<Integer> cache = new LinkedList();
        int count = 0;
        for (int num:array) {
            if (cache.contains(num)) cache.remove(num);
            else {
                count++;
                if (size == cache.size())
                    cache.remove(0);
            }
            cache.add(num);
        }
        return count;
    }
}

