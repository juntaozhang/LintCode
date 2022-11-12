package cn.juntaozhang.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 不是贪婪算法？
 *
 * @author juntzhang
 */
public class L3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> cache = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer start = cache.get(c);
            if (start != null) {
                max = Integer.max(cache.size(), max);
                cache.clear();
                for (int j = i; j > start; j--) {
                    cache.put(s.charAt(j), j);
                }
            } else {
                cache.put(c, i);
            }
        }
        max = Integer.max(cache.size(), max);
        return max;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        q.offer(10);
        q.offer(11);
        q.offer(9);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

        System.out.println(new L3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new L3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new L3().lengthOfLongestSubstring("pwwkew"));
    }
}
