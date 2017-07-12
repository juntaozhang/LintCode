package cn.juntaozhang.lintcode;

import org.junit.Test;

/**
 * @author juntao zhang
 */
public class HighFrequent4 {
    class GuessGame {
        int guess(int num){
            return -1;
        }
    }
    class Solution extends GuessGame {
        /**
         * @param n an integer
         * @return the number you guess
         */
        public int guessNumber(int n) {
            long start = 1, end = n, middle;
            while (start < end) {
                middle = (start + end) / 2;
                switch (guess((int) middle)) {
                    case -1 :
                        end = middle - 1;
                        break;
                    case 1 :
                        start = middle + 1;
                        break;
                    case 0:
                        return (int)middle;
                }
            }
            return (int)start;
        }
    }

    public int[] searchRange(int[] A, int target) {
        int i, j;
        for (i = 0,j = A.length - 1 ; i<=j;) {
            if(target > A[i]){
                i++;
            }
            if(target < A[j]){
                j--;
            }
            if (A[i] == A[j]) {
                break;
            }
        }
        if (i <= j && A[i] == A[j] && A[j] == target) {
            return new int[]{i, j};
        }
        return new int[]{-1, -1};
    }

    @Test
    public void searchRange() {
        System.out.println(searchRange(new int[]{1,3,5,6,8,9},7));
    }

}
