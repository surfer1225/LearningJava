package main.java.Company.Facebook;

public class Read4 {
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];

        int cnt = 0;
        int readNum;
        while ((readNum = read4(buf4))>0) {
            int i = 0;
            while (cnt<n && i<readNum) {
                buf[cnt++]=buf4[i++];
            }
        }
        return cnt;
    }

    private int read4(char[] buf) {
        return 4;
    }
}
