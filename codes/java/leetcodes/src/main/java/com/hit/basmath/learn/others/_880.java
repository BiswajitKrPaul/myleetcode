package com.hit.basmath.learn.others;

/**
 * 880. Decoded String at Index
 * <p>
 * An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:
 * <p>
 * If the character read is a letter, that letter is written onto the tape.
 * If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
 * Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "leet2code3", K = 10
 * Output: "o"
 * Explanation:
 * The decoded string is "leetleetcodeleetleetcodeleetleetcode".
 * The 10th letter in the string is "o".
 * <p>
 * Example 2:
 * <p>
 * Input: S = "ha22", K = 5
 * Output: "h"
 * Explanation:
 * The decoded string is "hahahaha".  The 5th letter is "h".
 * <p>
 * Example 3:
 * <p>
 * Input: S = "a2345678999999999999999", K = 1
 * Output: "a"
 * Explanation:
 * The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".
 * <p>
 * Note:
 * <p>
 * 2 <= S.length <= 100
 * S will only contain lowercase letters and digits 2 through 9.
 * S starts with a letter.
 * 1 <= K <= 10^9
 * The decoded string is guaranteed to have less than 2^63 letters.
 */
public class _880 {
    public String decodeAtIndex(String S, int K) {
        String cur = "";
        long curlen = 0;
        for (int i = 0; i < S.length(); i++) {
            char curchar = S.charAt(i);
            if (Character.isLetter(curchar)) {
                curlen += 1;
                if (curlen > K - 1) {
                    return "" + curchar;
                }
            }
            if (Character.isDigit(curchar)) {
                int times = curchar - '0';
                long prelen = curlen;
                curlen *= times;
                if (curlen > K - 1) {
                    return decodeAtIndex(S, (K - 1) % (int) prelen + 1);
                }
            }
        }
        return "";
    }
}
