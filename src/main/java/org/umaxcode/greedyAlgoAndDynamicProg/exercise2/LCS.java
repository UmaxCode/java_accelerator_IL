package org.umaxcode.greedyAlgoAndDynamicProg.exercise2;

public class LCS {

    // Function to find the length of LCS using Dynamic Programming
    public static int lcsLength(String x, String y) {

        int lenx = x.length();
        int leny = y.length();
        return createAndFlipTable(x, lenx, y, leny)[lenx][leny];
    }

    // Function to find the LCS string using the DP table
    public static String lcsString(String x, String y) {
        int lenx = x.length();
        int leny = y.length();

        int[][] dp = createAndFlipTable(x, lenx, y, leny);

        // Backtrack to find the LCS string
        StringBuilder lcs = new StringBuilder();
        int i = lenx, j = leny;

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                lcs.insert(0, x.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.toString();
    }

    private static int[][] createAndFlipTable(String x, int lenX, String y, int lenY) {

        // Create a DP table to store lengths of longest common subsequence
        int[][] dp = new int[lenX + 1][lenY + 1];

        // Fill the DP table
        for (int i = 1; i <= lenX; i++) {
            for (int j = 1; j <= lenY; j++) {
                // If characters match, increment the LCS length
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If characters don't match, take the maximum from the previous states
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }
}
