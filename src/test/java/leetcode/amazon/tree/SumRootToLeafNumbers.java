package leetcode.amazon.tree;

import leetcode.amazon.tree.BinaryTree.TreeNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumRootToLeafNumbers {
    
    public int sumNumbers(TreeNode root) {
        
        return sum(root, 0);
    }
    
    private int sum(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return i * 10 + root.val;
        }
        int leftSum = sum(root.left, i * 10 + root.val);
        int rightSum = sum(root.right, i * 10 + root.val);
        return leftSum + rightSum;
    }
    
    @Test
    public void shouldReturnLeftSubTree() {
        
        BinaryTree bt = new BinaryTree(new Integer[]{1, 2, null, 3});
        
        int actual = sumNumbers(bt.root);
        
        assertThat(actual).isEqualTo(123);
    }
    
    @Test
    public void shouldReturnRightSubTree() {
        
        BinaryTree bt = new BinaryTree(new Integer[]{1,null, 2,null,null, null, 3});
        
        int actual = sumNumbers(bt.root);
        
        assertThat(actual).isEqualTo(123);
    }
    
    @Test
    public void shouldSumBothChildren() {
        
        BinaryTree bt = new BinaryTree(new Integer[]{1, 2,3});
        
        int actual = sumNumbers(bt.root);
        
        assertThat(actual).isEqualTo(25);
    }
}
