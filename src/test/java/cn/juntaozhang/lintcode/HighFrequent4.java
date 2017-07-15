package cn.juntaozhang.lintcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author juntao zhang
 */
public class HighFrequent4 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TreeNode{");
            sb.append("val=").append(val);
            sb.append(", left=").append(left);
            sb.append(", right=").append(right);
            sb.append('}');
            return sb.toString();
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode n) {
        TreeNode p = root, pre = p;
        while (p != null) {
            if (p.val < n.val) {
                pre = p;
                p = p.right;
            } else if (p.val > n.val) {
                pre = p;
                p = p.left;
            } else {
                break;
            }
        }

        //找到最左边
        if (p != null) {
            if( p.left == null && p.right == null )
                return pre;

            while (true) {
                if (p.left != null) {
                    p = p.left;
                } else if (p.right != null) {
                    p = p.right;
                } else {
                    break;
                }
            }
        }
        return p;
    }

    @Test
    public void inorderSuccessor() {
//        TreeNode root = buildRoot("7,2,8,1,6,#,10,#,#,3,#,9,11,#,5,#,#,#,#,4");
        TreeNode root = buildRoot("2,1,3");
        System.out.println(inorderSuccessor(root, new TreeNode(2)));
        ;
    }

    private TreeNode buildRoot(String str) {
        String[] arr = str.split(",");
        TreeNode[] node = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("#"))
                node[i] = new TreeNode(Integer.valueOf(arr[i]));
        }
        for (int i = 0; i < arr.length; i++) {
            if (node[i] != null) {
                if (i * 2 + 1 < arr.length)
                    node[i].left = node[i * 2 + 1];
                if (i * 2 + 2 < arr.length)
                    node[i].right = node[i * 2 + 2];
            }

        }
        return node[0];
    }


    class GuessGame {
        int guess(int num) {
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
                    case -1:
                        end = middle - 1;
                        break;
                    case 1:
                        start = middle + 1;
                        break;
                    case 0:
                        return (int) middle;
                }
            }
            return (int) start;
        }
    }

    public int[] searchRange(int[] A, int target) {
        int i, j;
        for (i = 0, j = A.length - 1; i <= j; ) {
            if (target > A[i]) {
                i++;
            }
            if (target < A[j]) {
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
        System.out.println(searchRange(new int[]{1, 3, 5, 6, 8, 9}, 7));
    }


}
