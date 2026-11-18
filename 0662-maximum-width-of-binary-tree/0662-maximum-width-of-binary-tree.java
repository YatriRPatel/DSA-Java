/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
        TreeNode node;
        int idx;
        Pair(TreeNode n, int i) {
            node = n;
            idx = i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            int n = q.size();
            int min = q.peek().idx;
            int first = 0, last = 0;
            
            for (int i = 0; i < n; i++) {
                Pair curr = q.poll();
                int curIdx = curr.idx - min;
                
                if (i == 0) first = curIdx;
                if (i == n - 1) last = curIdx;
                
                if (curr.node.left != null) {
                    q.add(new Pair(curr.node.left, curIdx * 2 + 1));
                }
                if (curr.node.right != null) {
                    q.add(new Pair(curr.node.right, curIdx * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        
        return ans;
    }
}