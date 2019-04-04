package leetcode.amazon.tree;

import common.BST;
import common.TreeNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class InorderSuccessorInBST {
    
    @Test
    public void testExampe1() {
        BST bst = new BST(new Integer[]{2, 1, 3});
        TreeNode treeNode = inorderSuccessor(bst.root, new TreeNode(1));
        assertThat(treeNode.val).isEqualTo(2);
    }
    
    @Test
    public void testExampe2() {
        BST bst = new BST(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        TreeNode treeNode = inorderSuccessor(bst.root, new TreeNode(6));
        assertThat(treeNode).isNull();
    }
    
    @Test
    public void test00() {
        BST bst = new BST(new Integer[]{0});
        TreeNode treeNode = inorderSuccessor(bst.root, new TreeNode(0));
        assertThat(treeNode).isNull();
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        if (root == null) {
            return null;
        }
        
        if (p.val < root.val) {
            TreeNode leftNode = inorderSuccessor(root.left, p);
            return leftNode == null ? root : leftNode;
        } else if (p.val == root.val) {
            return inorderSuccessor(root.right,p);
        }else {
            return inorderSuccessor(root.right,p);
        }
        
    }
    
    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        
        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }
}
