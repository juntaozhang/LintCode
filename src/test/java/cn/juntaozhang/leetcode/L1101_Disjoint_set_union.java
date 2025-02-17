package cn.juntaozhang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author juntao zhang
 */
public class L1101_Disjoint_set_union {
    class Solution {
        /**
         * 并查集
         * https://www.youtube.com/watch?v=gpmOaSBcbYA
         * Disjoint-set union
         */
        class DSU {
            private int[] parent;
            private int[] rank;
            public int count;

            public DSU(int n) {
                this.count = n;
                this.parent = new int[n];
                this.rank = new int[n];
                for (int i = 0; i < n; i++) {
                    this.parent[i] = -1;
                    this.rank[i] = 1;
                }
            }

            public int find(int i) {
                int root = i;
                while (parent[root] != -1) {
                    root = parent[root];
                }
                return root;
            }

            public int union(int x, int y) {
                int xRoot = find(x);
                int yRoot = find(y);
                if (xRoot == yRoot) {
                    return 0;
                } else {
                    if (this.rank[xRoot] > this.rank[yRoot]) {
                        this.parent[yRoot] = xRoot;
                    } else if (this.rank[yRoot] > this.rank[xRoot]) {
                        this.parent[xRoot] = yRoot;
                    } else {
                        this.parent[xRoot] = yRoot;
                        this.rank[yRoot] += 1;
                    }
                    this.count--;
                    return 1;
                }
            }
        }

        public int earliestAcq(int[][] logs, int N) {
            List<int[]> list = new ArrayList<>();
            for (int[] log : logs) {
                list.add(log);
            }
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            DSU dsu = new DSU(N);
            int time = -1;
            for (int[] log : list) {
                if (dsu.union(log[1], log[2]) == 1) {
                    time = log[0];
                    if (dsu.count == 1) {
                        return time;
                    }
                }

            }
            if (dsu.count == 1) {
                return time;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new L1101_Disjoint_set_union().new Solution();
        int time = s.earliestAcq(new int[][]{
                {20190101, 0, 1}, {20190104, 3, 4},
                {20190107, 2, 3}, {20190211, 1, 5},
                {20190224, 2, 4}, {20190301, 0, 3},
                {20190312, 1, 2}, {20190322, 4, 5}
        }, 6);
//        int time = s.earliestAcq(new int[][]{
//                {0, 2, 7}, {12, 3, 1}, {6, 2, 4}, {7, 7, 3},
//                {5, 5, 2}, {10, 2, 4}, {1, 5, 0}, {3, 4, 5},
//                {9, 0, 3}, {4, 2, 7}, {11, 0, 5}, {8, 5, 2},
//                {2, 5, 3}
//        }, 8);
        System.out.println(time);
    }
}