package cn.juntaozhang.leetcode.dp;

public class L85 {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] h = new int[n][m];
        int[][][] dp = new int[n][m][n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i > 0) {
                        h[i][j] = h[i - 1][j];
                    }
                    h[i][j] += 1;
                }

                for (int k = 1; k <= h[i][j]; k++) {
                    if (j > 0) {
                        dp[i][j][k] = dp[i][j - 1][k];
                    }
                    dp[i][j][k] += k;
                    ans = Math.max(ans, dp[i][j][k]);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new L85().maximalRectangle(new char[][]{{'1'}, {'1'}}));
        System.out.println(new L85().maximalRectangle(new char[][]{{'1', '1'}}));
        System.out.println(new L85().maximalRectangle(
                new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }
        ));
        System.out.println(new L85().maximalRectangle(new char[][]{{'0'}}));
        System.out.println(new L85().maximalRectangle(new char[][]{{'1'}}));
    }
}
