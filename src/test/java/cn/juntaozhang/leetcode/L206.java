package cn.juntaozhang.leetcode;

/**
 * @author juntao zhang
 */
public class L206 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode c = head, t, ans = null;
            while (c != null) {
                t = c.next;
                c.next = ans;
                ans = c;
                c = t;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution s = new L206().new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        s.reverseList(l3);
    }
}
