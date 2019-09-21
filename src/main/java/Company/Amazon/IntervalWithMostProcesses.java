package main.java.Company.Amazon;

import java.util.List;

public class IntervalWithMostProcesses {

    class Process {
        int start;
        int end;
    }

    class ProcessCount {
        int startCnt;
        int endCnt;
    }

    public int getIntervalWithMostProcesses(List<Process> processes) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Process p:processes) {
            min = Math.min(min, p.start);
            max = Math.max(max, p.end);
        }

        ProcessCount[] processArr = new ProcessCount[max-min+1];

        for (Process p:processes) {
            processArr[p.start - min].startCnt++;
            processArr[p.end - max].endCnt++;
        }

        int prev = processArr[0].startCnt;
        int maxCnt = prev;
        for (int i=1;i<processArr.length;++i) {
            prev+=processArr[i].startCnt;
            prev-=processArr[i].endCnt;
            maxCnt=Math.max(maxCnt,prev);
        }

        return maxCnt;
    }
}
