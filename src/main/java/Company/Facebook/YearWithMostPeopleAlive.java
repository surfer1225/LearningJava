package main.java.Company.Facebook;

import java.util.Arrays;
import java.util.Comparator;

/*
Given a list of people with birth year and death year information

find the year with the most number of people alive
 */
public class YearWithMostPeopleAlive {

    class Person {
        int birthYear;
        int deathYear;
    }

    public int getPopulationPeak(Person[] persons) {
        int firstBirth = getMinBirth(persons);
        int lastDeath = getLastDeath(persons);

        int[] deltaArr = getDeltas(persons, firstBirth, lastDeath);
        return getMaxRunningSumIndex(deltaArr) + firstBirth;
    }

    private int getMinBirth(Person[] persons) {
        return Arrays.stream(persons).mapToInt(p -> p.birthYear).min().getAsInt();
    }

    private int getLastDeath(Person[] persons) {
        return Arrays.stream(persons).mapToInt(p -> p.deathYear).max().getAsInt();
    }

    private int[] getDeltas(Person[] persons, int firstBirth, int lastDeath) {
        int[] deltaArr = new int[lastDeath - firstBirth + 1];
        for (Person p:persons) {
            deltaArr[p.birthYear-firstBirth]++;
            if (p.deathYear!=lastDeath) deltaArr[p.deathYear-firstBirth+1]--;
        }
        return deltaArr;
    }

    private int getMaxRunningSumIndex(int[] deltaArr) {
        int runningSum = 0;
        int maxRunningSum = 0;
        int yearOfPeak = -1;

        for (int year=0;year<deltaArr.length;year++) {
            runningSum += deltaArr[year];
            if (runningSum>maxRunningSum) {
                yearOfPeak = year;
                maxRunningSum = runningSum;
            }
        }

        return yearOfPeak;
    }
}
