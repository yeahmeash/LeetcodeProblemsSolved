class Node {
    Node[] freq = new Node[2];
    boolean flag = false;

    public boolean contains(int idx) {
        return freq[idx] != null;
    }

    public void put(int idx, Node newN) {
        freq[idx] = newN;
    }

    public Node get(int idx) {
        return freq[idx];
    }
}

class Trie {
    Node head;

    public Trie() {
        head = new Node();
    }

    public void insert(int num) {
        Node cpy = head;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!cpy.contains(bit)) {
                cpy.put(bit, new Node());
            }

            cpy = cpy.get(bit);
        }
    }

    public int getMax(int num) {
        Node cpy = head;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (cpy.contains(1 - bit)) {
                maxNum |= (1 << i);
                cpy = cpy.get(1 - bit);
            } else {
                cpy = cpy.get(bit);
            }
        }
        return maxNum;
    }
}


// TC: O(n*log(N) + N*32)
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            list.add(new int[] { queries[i][0], queries[i][1], i });
        }

        Collections.sort(list, (a, b) -> a[1] - b[1]);

        Trie head = new Trie();
        int idx = 0;
        int[] xor = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = list.get(i)[0], m = list.get(i)[1], l_idx = list.get(i)[2];
            // System.out.println(l_idx);

            while (idx < nums.length && nums[idx] <= m) {
                head.insert(nums[idx]);
                idx++;
            }

            // max xor of element
            if (idx == 0) {
                xor[l_idx] = -1;
            } else {
                xor[l_idx] = head.getMax(x);
            }
        }
        return xor;
    }
}