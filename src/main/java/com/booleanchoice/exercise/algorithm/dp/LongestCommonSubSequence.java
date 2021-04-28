package com.booleanchoice.exercise.algorithm.dp;

/**
 * DP问题：最长公共子序列问题
 *
 * 给定两个字符串str1和str2，返回两个字符串的最长公共子序列
 * str1的长度为m，str2的长度为n
 */
public class LongestCommonSubSequence {

    /**
     * 获得dp表，dp表记录了两字符串的最长公共子序列*长度*
     * @param str1
     * @param str2
     * @return
     */
    public static int[][] getDp(char[] str1, char[] str2) {
        // 声明dp表，dp[i][j]表示str1[0...i]和str2[0...j]的最长公共子序列长度
        int[][] dp = new int[str1.length][str2.length];
        // dp表左上角的值看两字符串第一个字符是否相等
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        // 初始化dp表第一列的值，一旦dp[i][0]的值为1，那么dp[i+1...m-1][0]的值也将为1
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        // 初始化dp表第一行的值，一旦dp[0][j]的值为1，那么dp[0][j+1...n-1]的值也将为1
        for (int j = 1; j < str2.length; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
        }
        // 计算dp表其余部分dp[i][j]的值
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                // dp[i][j]有可能和它上边或者左边的记录相等，取两者最大值
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                // 如果str1[i]和str2[j]的字符相等，dp[i][j]也有可能是dp[i - 1][j - 1] + 1，取三者最大值
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }

    public static String getSubSequence(String str1, String str2) {
        if (null == str1 || null == str2 || "".equals(str1) || "".equals(str2)) {
            return "";
        }
        char[] str1CharArr = str1.toCharArray();
        char[] str2CharArr = str2.toCharArray();
        int[][] dp = getDp(str1CharArr, str2CharArr);
        int m = str1CharArr.length - 1;
        int n = str2CharArr.length - 1;
        // 结果数组大小为dp表右下角的值，也就是最长公共子序列长度
        char[] result = new char[dp[m][n]];
        // 声明一个结果数组的指针i
        int i = result.length - 1;
        // 从后向前装填结果数组，每装填一次，指针向前移动一位，直到装填完成
        while (i >= 0) {
            // 如果dp[m][n]的大小和它上边位置的值相等，则不用装填结果数组，dp上移
            if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            }
            // 如果dp[m][n]的大小和它左边位置的值相等，则不用装填结果数组，dp左移
            else if (n > 0 && dp[m][n] == dp[m][n -1 ]) {
                n--;
            }
            // 排除以上两种情况，dp[m][n]即为它左上角的值加一的情况，
            // 此时str1[m]等于str2[n],这个字符一定属于最长公共子序列，把它填充进结果数组，
            // i指针左移，并且dp向左上方移动
            else {
                result[i--] = str1CharArr[m];
                m--;
                n--;
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println("最长公共子序列为：" + getSubSequence("A12B3CD", "A1B234CE"));
    }

}
