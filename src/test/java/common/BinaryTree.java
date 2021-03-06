package common;

public class BinaryTree {
    
    public TreeNode root;
    public Integer arr[];
    
    public BinaryTree(Integer[] arr) {
        this.arr = arr;
        root = addNode(0, root);
    }
    
    private TreeNode addNode(int i, TreeNode cur) {
        if (i < arr.length && arr[i]!=null) {
            cur = new TreeNode(arr[i]);
            if (i * 2 + 1 < arr.length) {
               cur.left= addNode(i * 2 + 1, cur.left);
            }
            if (i * 2 + 2 < arr.length) {
               cur.right = addNode(i * 2 + 2, cur.right);
            }
        }
        return cur;
    }
    
}
