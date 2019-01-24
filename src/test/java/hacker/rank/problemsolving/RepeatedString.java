package hacker.rank.problemsolving;

import org.junit.Test;

public class RepeatedString {

    @Test
    public void testRepeatedString() {
        String s = "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm";
        long n = 736778906400L;
        long numOfAInS = s.chars().filter(c -> c == 'a').count();
        //calculate 's's in n;
        long numOfS = n / s.length();
        //calculate 'a' in the last part of a 's'
        long numOfAInLast = s.substring(0, (int) (n % s.length())).chars().filter(c -> c == 'a').count();

        System.out.println(numOfAInS * numOfS + numOfAInLast);

    }
}
