package leetcode.amazon.tree;

import common.BinaryTree;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    
    @Test
    public void testExample1() {
        BinaryTree binaryTree = new BinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        
        List<List<Integer>> ans = levelOrder(binaryTree.root);
        
        ans.stream().forEach(level -> {
            System.out.println();
            System.out.print("[");
            level.stream().forEach(node -> {
                System.out.print(node + ",");
            });
            System.out.print("]");
        });
        
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        
        if (root == null) {
            return ans;
        }
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            List<Integer> subList = new LinkedList();
            int numLevel = queue.size();
            for (int i = 0; i < numLevel; i++) {
                TreeNode curr = queue.peek();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                subList.add(queue.poll().val);
            }
            ans.add(subList);
        }
        
        return ans;
    }
}
