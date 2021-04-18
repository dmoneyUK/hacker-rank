package leetcode.amazon.tree;

import common.BinaryTree;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BTreeVerticalOrderTraversal {
    @Test
    public void testExampe1() {
        Integer[] arr = {3, 9, 8, 4, 0, 1, 7, null, null, null, 2, 5};
        
        BinaryTree binaryTree = new BinaryTree(arr);
        
        List<List<Integer>> lists = verticalOrder(binaryTree.root);
        lists.size();
        
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> values = new LinkedList<>();
        Queue<Integer> columns = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        values.offer(root);
        columns.offer(0);
        Integer min = 0, max = 0;
        
        while (!values.isEmpty()) {
            TreeNode node = values.poll();
            Integer col = columns.poll();
            
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);
            
            if (node.left != null) {
                values.offer(node.left);
                columns.offer(col - 1);
                min = Math.min(min, col - 1);
            }
            
            if (node.right != null) {
                values.offer(node.right);
                columns.offer(col + 1);
                max = Math.max(max, col + 1);
            }
            
        }
        for (Integer i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
    
}
