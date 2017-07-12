package cn.juntaozhang.lintcode;

import org.junit.Test;

/**
 * @author juntao zhang
 */
public class Backpack {
    //i为容量
    //dp[m-A[i]] => 递归
    //             不包含      包含 a[i]
    //dp[i] = max(dp[i], dp[m-A[i]]+a[i])
    public int backPack(int m, int[] A) {
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j > 0; j--) {
                if (j >= A[i]) {
                    dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
                }
            }
        }
        return dp[m];
    }

    public int backPack2(int m, int[] A) {
        int[] dp = new int[m + 1];
        for (int a : A) {
            for (int i = m; i > 0; i--) {
                if (i >= a) {
                    dp[i] = Math.max(dp[i], dp[i - a] + a);
                }
            }
        }
        return dp[m];
    }

    @Test
    public void backPack() {
        System.out.println(backPack2(10, new int[]{3, 4, 8, 5}));
    }
}
