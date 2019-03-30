package leetcode.amazon.tree;

import common.TreeNode;
import org.junit.Test;

public class ClosestValue {
    
    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        
        int r = closestValue(root, 2.714286);
        System.out.println(r);
    }
    
    public int closestValueRec(TreeNode root, double target) {
        
        int result;
        if (root == null) {
            return -1;
        } else if (target < root.val) {
            result = closestValue(root.left, target);
        } else {
            result = closestValue(root.right, target);
        }
        
        if (result == -1) {
            return root.val;
        }
        
        return Math.abs(result - target) < Math.abs(root.val - target) ? result : root.val;
    }
    
    public int closestValue(TreeNode root, double target) {
        int last = root.val;
        while (root != null && Math.abs(root.val - target) <= Math.abs(last - target)) {
            last = root.val;
            root = target < root.val ? root.left : root.right;
        }
        return last;
        
    }
}
