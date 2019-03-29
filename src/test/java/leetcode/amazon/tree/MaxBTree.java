package leetcode.amazon.tree;

import leetcode.amazon.tree.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxBTree {
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        if (nums == null) {
            return null;
        }
    
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int i : nums) {
            TreeNode curr = new TreeNode(i);
            while (!stack.isEmpty() && stack.peek().val < i) {
                curr.left = stack.pop();
            }
            
            if (!stack.isEmpty()) {
                stack.pop().right = curr;
            }
            
            stack.push(curr);
    
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }
}
