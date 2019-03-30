package leetcode.amazon.tree;

import common.TreeNode;
import org.junit.Test;

public class ValidBST {
    
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        //root.right = new TreeNode(4);
        //root.right.left= new TreeNode(3);
        //root.right.right= new TreeNode(6);
    
        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, int low, int high){
        if(root==null){
            return true;
        }
        if(root.val<low || root.val>=high) return false;
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
        
    }
    
   
}
