package common;

import java.util.Arrays;

public class BST {
    
    public TreeNode root;
    
    public BST(int[] arr) {
        Arrays.stream(arr)
              .forEach(e -> root = addRecursive(root, e));
    }
    
    public long getMax() {
        return getRightRecursive(root).val;
    }
    
    private TreeNode getRightRecursive(TreeNode current) {
        if (current.right == null) {
            return current;
        }
        return getRightRecursive(current.right);
    }
    
    private TreeNode addRecursive(TreeNode current, int newValue) {
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
