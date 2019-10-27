package main.java.Company.Facebook;

/*
253. Meeting Rooms II

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
find the minimum number of conference rooms required.
Example 1:
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Example 2:
Input: [[7,10],[2,4]]
Output: 1

NOTE: input types have been changed on April 15, 2019.
Please reset to default code definition to get new method signature.
 */

public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        int[] minMax = new int[2];
        minMax[0] = Integer.MAX_VALUE;
        minMax[1] = Integer.MIN_VALUE;

        setMinStart(intervals, minMax);

        int[] meetingTime = new int[minMax[1] - minMax[0] + 1];
        populateMeetingTime(intervals,meetingTime,minMax[0]);

        int runningSum = 0;
        int maxConcurrentMeeting = Integer.MIN_VALUE;

        for (int time:meetingTime) {
            runningSum += time;
            maxConcurrentMeeting = Math.max(maxConcurrentMeeting, runningSum);
        }

        return maxConcurrentMeeting;
    }

    private void populateMeetingTime(int[][] intervals, int[] meetingTime, int offset) {
        for (int[] interval:intervals) {
            meetingTime[interval[0]-offset]++;
            meetingTime[interval[1]-offset]--;
        }
    }

    private void setMinStart(int[][] intervals, int[] minMax) {
        for (int[] interval:intervals) {
            minMax[0] = Math.min(minMax[0], interval[0]);
            minMax[1] = Math.max(minMax[1], interval[1]);
        }
    }
}

/*

 * Definition for an interval. public class Interval { int start; int end; Interval() { start = 0;
 * end = 0; } Interval(int s, int e) { start = s; end = e; } }

class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }
        // Min heap
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });
        // Sort the intervals by start time
        Arrays.sort(
                intervals,
                new Comparator<Interval>() {
                    public int compare(Interval a, Interval b) {
                        return a.start - b.start;
                    }
                });
        // Add the first meeting
        allocator.add(intervals[0].end);
        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i].start >= allocator.peek()) {
                allocator.poll();
            }
            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i].end);
        }
        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
}

 */

/**
 * Definition for an interval. public class Interval { int start; int end; Interval() { start = 0;
 * end = 0; } Interval(int s, int e) { start = s; end = e; } }

 class Solution {
 public int minMeetingRooms(Interval[] intervals) {
 // Check for the base case. If there are no intervals, return 0
 if (intervals.length == 0) {
 return 0;
 }
 Integer[] start = new Integer[intervals.length];
 Integer[] end = new Integer[intervals.length];
 for (int i = 0; i < intervals.length; i++) {
 start[i] = intervals[i].start;
 end[i] = intervals[i].end;
 }
 // Sort the intervals by end time
 Arrays.sort(
 end,
 new Comparator<Integer>() {
 public int compare(Integer a, Integer b) {
 return a - b;
 }
 });
 // Sort the intervals by start time
 Arrays.sort(
 start,
 new Comparator<Integer>() {
 public int compare(Integer a, Integer b) {
 return a - b;
 }
 });
 // The two pointers in the algorithm: e_ptr and s_ptr.
 int startPointer = 0, endPointer = 0;
 // Variables to keep track of maximum number of rooms used.
 int usedRooms = 0;
 // Iterate over intervals.
 while (startPointer < intervals.length) {
 // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
 if (start[startPointer] >= end[endPointer]) {
 usedRooms -= 1;
 endPointer += 1;
 }
 // We do this irrespective of whether a room frees up or not.
 // If a room got free, then this used_rooms += 1 wouldn't have any effect. used_rooms would
 // remain the same in that case. If no room was free, then this would increase used_rooms
 usedRooms += 1;
 startPointer += 1;
 }
 return usedRooms;
 }
 }
 */
