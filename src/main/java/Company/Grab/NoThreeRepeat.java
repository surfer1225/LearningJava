package main.java.Company.Grab;

/*
A means number of 'a'
B means number of 'b'
no repeated 'a' or 'b' allowed
get 1 random string returned
 */
public class NoThreeRepeat {
    public String solution(int A, int B) {
        StringBuilder sb = new StringBuilder();
        char forA = 'a';
        char forB = 'b';

        if (A<B) {
            int temp = A;
            A = B;
            B = temp;
            forA = 'b';
            forB = 'a';
        }

        while (A+B>0) {
            if (B*2<A) {
                sb.append(forA);
                A--;
            }
            if (A>0) {
                A--;
                sb.append(forA);
            }
            if (B>0) {
                sb.append(forB);
                B--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NoThreeRepeat n = new NoThreeRepeat();
        System.out.println(n.solution(1,4));
        System.out.println(n.solution(3,3));
        System.out.println(n.solution(5,3));
        System.out.println(n.solution(2,0));
    }
}
