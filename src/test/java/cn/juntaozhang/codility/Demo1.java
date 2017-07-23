package cn.juntaozhang.codility;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author juntao zhang
 */
public class Demo1 {
    @Test
    public void test(){
        System.out.println(backPack(10,new int[]{3}));
    }

    public int backPack(int m, int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int[] dp = new int[m + 1];
        // dp[i] = max(dp[i - a] + a, dp[i])
        for (int a : A) {
            for (int i = m; i >= 0; i--) {
                if (i >= a) {
                    dp[i] = Math.max(dp[i - a] + a, dp[i]);
                }
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[m];
    }
}
