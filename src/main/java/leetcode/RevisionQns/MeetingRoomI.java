package main.java.leetcode.RevisionQns;

import java.util.Arrays;
import java.util.Comparator;

/*
252. given a list of intervals, check if there is a clash
 */
public class MeetingRoomI {
    class Interval {
        int start;
        int end;
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i].end>intervals[i+1].start){
                return false;
            }
        }

        return true;
    }
}
