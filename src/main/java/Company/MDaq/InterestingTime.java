package main.java.Company.MDaq;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Find all interesting time between 2 timestamps

interesting time: hh,mm,ss only consists of 2 different numerical digits
 */
public class InterestingTime {
    public int solution(String S, String T) {
        if(T==null || S==null ) return 0;
        int[] start=new int[3];
        int[] end=new int[3];
        String[] split = S.split(":");
        for(int i=0;i<3;i++){
            start[i]=Integer.parseInt(split[i]);
        }
        split = T.split(":");
        for(int i=0;i<3;i++){
            end[i]=Integer.parseInt(split[i]);
        }

        int cnt=0;

        for(int hour=start[0];hour<=end[0];hour++){
            int[] digit = new int[2];
            digit[0] = hour/10;
            digit[1] = hour%10;
            List<Integer> integers = buildList(digit);
            for(Integer min: integers){
                for(Integer sec : integers){
                    int[] time=new int[3];
                    time[0]= hour;
                    time[1]=min;
                    time[2]=sec;
                    if(compare(time,start)>=0 && compare(time,end)<=0 && digitCnt(time)<=2){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private int digitCnt(int[] time) {
        Set<Integer> digitSet = new HashSet<>();
        for(int i=0;i<time.length;i++){
            digitSet.add(time[i]/10);
            digitSet.add(time[i]%10);
        }
        return digitSet.size();
    }

    private List<Integer> buildList(int[] digit){
        List<Integer> intList = new ArrayList<>();
        if(digit[0]!=digit[1]){
            int small=digit[0]>digit[1]?digit[1]:digit[0];
            int large=digit[0]>digit[1]?digit[0]:digit[1];
            if(small*11<60)
                intList.add(small*11);
            if(small*10+large<60)
                intList.add(small*10+large);
            if(large*10+small<60)
                intList.add(large*10+small);
            if(large*11<60)
                intList.add(large*11);
        }else{
            for(int i=0;i<6;i++){
                intList.add(i*11);
                if(i!=digit[0] && i*10+digit[0]<60)
                    intList.add(i*10+digit[0]);
            }
            for(int i=0;i<10;i++){
                if(i!=digit[0] && digit[0]*10+i<60){
                    intList.add(digit[0]*10+i);
                }
            }
        }
        return intList;
    }


    private int compare(int[] a, int[] b){
        if(a==null || b==null || a.length!=3 || b.length!=3) return 0;
        if(a[0]>b[0]){
            return 1;
        }else if(a[0]<b[0]){
            return -1;
        }else{
            if(a[1]>b[1]){
                return 1;
            }else if(a[1]<b[1]){
                return -1;
            }else {
                if(a[2]>b[2]){
                    return 1;
                }else if(a[2]<b[2]){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }

    public static void main(String[] main) {
        InterestingTime it = new InterestingTime();
        System.out.println(it.solution("16:16:15", "18:20:20"));
    }
}
