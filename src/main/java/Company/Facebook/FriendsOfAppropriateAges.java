package main.java.Company.Facebook;

/*
825. Friends Of Appropriate Ages

Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person.

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?

Example 1:

Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.
Example 2:

Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.
Example 3:

Input: [20,30,100,110,120]
Output:
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
 */
public class FriendsOfAppropriateAges {

    public int numFriendRequestsON(int[] ages) {
        int[] range = new int[121];
        int[] allAges = new int[121];
        for(int a: ages){
            if(a>=15){ // used age to come up with all valid range
                range[(int)(a*0.5+7)]++;
                range[a]--;
            }
            allAges[a]++; // count all ages
        }
        int res = 0, currentRange = 0;
        for(int i = 0; i<121; i++){
            if(allAges[i]>0){
                res+= (currentRange*allAges[i]>0? currentRange*allAges[i]-allAges[i]: 0);
                //currentRange*allAges[i]-allAges[i] means eliminating itself
            }
            currentRange+=range[i];
        }
        return res;
    }

    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age: ages) count[age]++;

        int ans = 0;
        for (int ageA = 0; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 0; ageB <= 120; ageB++) {
                int countB = count[ageB];
                if (ageA * 0.5 + 7 >= ageB) continue;
                if (ageA < ageB) continue;
                if (ageA < 100 && 100 < ageB) continue;
                ans += countA * countB;
                if (ageA == ageB) ans -= countA;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FriendsOfAppropriateAges f = new FriendsOfAppropriateAges();
        System.out.println(f.numFriendRequestsON(new int[]{16,17,18}));
    }
}
