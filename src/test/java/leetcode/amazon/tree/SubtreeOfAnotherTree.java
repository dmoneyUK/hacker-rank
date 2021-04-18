package leetcode.amazon.tree;

import common.BinaryTree;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtreeOfAnotherTree {
    
    @Test
    public void testExample1(){
        Integer[] arr = {3,4,5,1,2};
        BinaryTree s = new BinaryTree(arr);
        
        Integer[] sub = {4,1,2};
        BinaryTree t = new BinaryTree(arr);
        boolean ans = isSubtree(s.root, t.root);
        
        assertThat(ans).isTrue();
    
    }
    
    @Test
    public void test11And1(){
        Integer[] arr = {1,1};
        BinaryTree s = new BinaryTree(arr);
        
        Integer[] sub = {1};
        BinaryTree t = new BinaryTree(arr);
        boolean ans = isSubtree(s.root, t.root);
        
        assertThat(ans).isTrue();
        
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        TreeNode root = findRecursively(s, t);
        return equals(root, t);
    }
    
    public boolean equals(TreeNode o1, TreeNode o2) {
        
        if(o1 ==null && o2==null){
            return true;
        }else if(o1==null || o2==null){
            return false;
        }else if (o1.val != o2.val) {
            return false;
        }else{
            return equals(o1.left, o2.left) && equals(o1.right, o2.right);
        }
    }
    
    public TreeNode findRecursively(TreeNode s, TreeNode t) {
        TreeNode result;
        if (s == null || s.val == t.val) {
            result = s;
        } else {
            result = findRecursively(s.right, t);
            if (result == null) {
                result = findRecursively(s.left, t);
            }
        }
        return result;
    }
    
}
