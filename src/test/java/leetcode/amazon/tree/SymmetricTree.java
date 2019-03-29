package leetcode.amazon.tree;

import static leetcode.amazon.tree.BinaryTree.*;

public class SymmetricTree {
    
    
    public boolean isSymmetric(TreeNode root) {
        return false;
    }
    
    public boolean isMirror(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left ==null || right ==null) return false;
        return left.val== right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
    
    
}
