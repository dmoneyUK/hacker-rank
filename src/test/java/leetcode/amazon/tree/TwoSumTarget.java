package leetcode.amazon.tree;

import common.BinaryTree;
import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumTarget {
    
    @Test
    public void test() {
        Integer[] arr = {5, 3, 6, 2, 4, null, 7};
        
        BinaryTree binaryTree = new BinaryTree(arr);
        assertThat(findTarget(binaryTree.root, 9)).isTrue();
    }
    
    @Test
    public void testShouldReturnFalse() {
        Integer[] arr = {5, 3, 6, 2, 4, null, 7};
        
        BinaryTree binaryTree = new BinaryTree(arr);
        assertThat(findTarget(binaryTree.root, 28)).isFalse();
    }
    
    @Test
    public void testRootIsNull() {
        
        findTarget(null, 9);
    }
    
    @Test
    public void testInput1() {
        Integer[] arr = {1};
        
        BinaryTree binaryTree = new BinaryTree(arr);
        
        assertThat(findTarget(binaryTree.root, 2)).isFalse();
    }
    
    @Test
    public void testInput213() {
        Integer[] arr = {2,1,3};
        
        BinaryTree binaryTree = new BinaryTree(arr);
        assertThat(findTarget(binaryTree.root, 4)).isTrue();
    }
    
    public boolean findTarget(TreeNode root, int k) {
        
        if (root == null) {
            return false;
        }
        
        TreeNode next = root;
        while (next.left != null) {
            next = next.left;
        }
        int min = next.val;
        
        next = root;
        while (next.right != null) {
            next = next.right;
        }
        int max = next.val;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        stack.push(curr);
        boolean found = false;
        
        while (!stack.isEmpty() && !found) {
            curr = stack.pop();
            int target = k - curr.val;
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (target < min || target > max  || k == 2 * curr.val) {
                continue;
            }
            found = findRecursively(root, target);
        }
        return found;
        
    }
    
    public boolean findRecursively(TreeNode curr, int target) {
        if (curr == null) {
            return false;
        } else if (curr.val == target) {
            return true;
        }
        return target > curr.val ? findRecursively(curr.right, target) : findRecursively(curr.left, target);
    }
}
