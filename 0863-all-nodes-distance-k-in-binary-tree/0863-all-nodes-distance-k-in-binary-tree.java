/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || target == null) return result;

        buildParentMap(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int currentDistance = 0;

        while (!queue.isEmpty()) {
            if (currentDistance == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    queue.offer(current.left);
                }

                if (current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    queue.offer(current.right);
                }

                TreeNode parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                }
            }
            currentDistance++;
        }

        return result;
    }

    private void buildParentMap(TreeNode node, TreeNode parent) {
        if (node == null) return;
        
        if (parent != null) {
            parentMap.put(node, parent);
        }
        
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }
}