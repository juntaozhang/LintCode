package cn.juntaozhang.leetcode.graph;

/**
 * @author juntzhang
 */
public class L1319_uf {

    public static class UnionFind {

        final int[] parents;
        final int[] ranks;
        int count;

        public UnionFind(int[][] connections, int n) {
            parents = new int[n];
            ranks = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
            count = n;
        }

        public int find(int x) {
            int p = parents[x];
            if (p == x) {
                return p;
            }
            parents[x] = find(p);
            return parents[x];
        }

        public void union(int x1, int x2) {
            int p1 = find(x1);
            int p2 = find(x2);
            if (p1 == p2) {
                return;
            }
            if (ranks[p1] > ranks[p2]) {
                parents[p2] = p1;
            } else if (ranks[p1] < ranks[p2]) {
                parents[p1] = p2;
            } else {
                parents[p1] = p2;
                ranks[p2]++;
            }
            count--;
        }

        public int getCount() {
            return count;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind uf = new UnionFind(connections, n);
        for (int[] conn : connections) {
            uf.union(conn[0], conn[1]);
        }
        return uf.getCount() - 1;
    }

    public static void main(String[] args) {
        System.out.println(new L1319_uf().makeConnected(4, new int[][]{
                {0, 1},
                {0, 2},
                {1, 2}
        }));
    }
}
