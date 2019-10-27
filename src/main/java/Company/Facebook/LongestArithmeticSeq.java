package main.java.Company.Facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestArithmeticSeq {
    // DP with O(n^2)
    public int longestArithSeqLength1(int[] A) {
        if (A==null || A.length==0) return 0;

        HashMap<Integer, Integer>[] indexCntDP = new HashMap[A.length];
        for (int i=0;i<A.length;++i) indexCntDP[i] = new HashMap<>();

        int max = 1;

        for (int i=1;i<A.length;++i) {
            for (int j=i-1;j>=0;--j) {
                int diff = A[i] - A[j];
                indexCntDP[i].put(diff,
                        Math.max(indexCntDP[i].getOrDefault(diff,2),
                                indexCntDP[j].containsKey(diff)?indexCntDP[j].get(diff)+1:2));
                max = Math.max(max, indexCntDP[i].get(diff));
            }
        }

        return max;
    }

    // O(n^4) but unlikely
    public int longestArithSeqLength2(int[] A) {
        if (A==null || A.length == 0) return 0;

        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i=0;i<A.length;++i) {
            indexMap.computeIfAbsent(A[i], placeholder -> new LinkedList<>()).add(i);
        }

        int max = 1;
        for (int i=0;i<A.length;++i) {
            for (int j=i+1;j<A.length;++j) {
                int cur = j, diff = A[j] - A[i];
                if (diff == 0) continue;
                int cnt = 2;
                while (indexMap.containsKey(A[cur]+diff) && !indexMap.get(A[cur]+diff).isEmpty()) {
                    boolean nextIndexFound = false;
                    for (int index: indexMap.get(A[cur]+diff)) {
                        if (index > cur) {
                            cnt++;
                            cur = index;
                            nextIndexFound = true;
                            break;
                        }
                    }
                    if (!nextIndexFound) break;
                }
                max = Math.max(max,cnt);
            }
        }

        return max;
    }
}
