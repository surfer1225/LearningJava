package main.java.Company.Facebook;

import java.util.Optional;

/*
Find whether String S is periodic, e.g. S = nP, "ababab" has "ab"
 */
public class StringPeriod {
    public boolean isPeriod(String s) {
        StringBuilder sb = new StringBuilder(s.concat(s));
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString().contains(s);
    }

    public Optional<String> getPeriod(String str) {
        String test = str + str;
        String sub = test.substring(1, test.length() - 1);
        int index = sub.indexOf(str);
        if (index < 0) {
            return Optional.empty();
        }
        return Optional.of(str.charAt(0) + sub.substring(0, index));
    }
}
