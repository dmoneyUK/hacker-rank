package common;

import java.util.Arrays;

public class BST {
    
    public TreeNode root;
    
    public BST(Integer[] arr) {
        Arrays.stream(arr)
              .forEach(e -> root = addRecursive(root, e));
    }
    
    public long getMax() {
        return getRightRecursive(root).val;
    }
    
    public TreeNode get(TreeNode curr, int i) {
        TreeNode ans;
        if (curr == null || curr.val == i) {
            ans = curr;
        } else if (curr.val > i) {
            ans = get(curr.left, i);
        } else {
            ans = get(curr.right, i);
        }
        return ans;
    }
    
    private TreeNode getRightRecursive(TreeNode current) {
        if (current.right == null) {
            return current;
        }
        return getRightRecursive(current.right);
    }
    
    private TreeNode addRecursive(TreeNode current, Integer newValue) {
        
        if(newValue==null) return current;
        TreeNode newNode = new TreeNode(newValue);
        if (current == null) {
            return newNode;
        }
        
        if (current.val > newValue) {
            current.left = addRecursive(current.left, newValue);
        } else if (current.val < newValue) {
            current.right = addRecursive(current.right, newValue);
        } else {
            return current;
        }
        return current;
        
    }
}
