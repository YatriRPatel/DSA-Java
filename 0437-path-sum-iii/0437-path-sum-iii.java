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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> counts = new HashMap<>();
        
        counts.put(0L, 1);
        
        return dfs(root, 0L, targetSum, counts);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> counts) {
        if (node == null) return 0;

        currentSum += node.val;

        int validPaths = counts.getOrDefault(currentSum - targetSum, 0);

        counts.put(currentSum, counts.getOrDefault(currentSum, 0) + 1);

        int total = validPaths + dfs(node.left, currentSum, targetSum, counts) + dfs(node.right, currentSum, targetSum, counts);

        counts.put(currentSum, counts.get(currentSum) - 1);

        return total;
    }
}