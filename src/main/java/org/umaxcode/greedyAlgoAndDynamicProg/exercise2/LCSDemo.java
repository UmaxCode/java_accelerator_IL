package org.umaxcode.greedyAlgoAndDynamicProg.exercise2;

import static org.umaxcode.greedyAlgoAndDynamicProg.exercise2.LCS.lcsLength;
import static org.umaxcode.greedyAlgoAndDynamicProg.exercise2.LCS.lcsString;

public class LCSDemo {

    public static void main(String[] args) {

        String firstString = "AGGTAB";
        String secondString = "GXTXAYB";

        // Get the length of the LCS
        int lcsLength = lcsLength(firstString, secondString);
        System.out.println("Length of LCS: " + lcsLength);

        // Get the LCS string
        String lcs = lcsString(firstString, secondString);
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}
