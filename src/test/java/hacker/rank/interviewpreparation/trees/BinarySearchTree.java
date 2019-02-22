package hacker.rank.interviewpreparation.trees;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://www.baeldung.com/java-binary-tree
 */
public class BinarySearchTree {

    private Node root;

    private Node addRecursive(Node current, int newKey) {

        if (current == null) {
            return new Node(newKey);
        }

        if (newKey < current.key) {
            current.left = addRecursive(current.left, newKey);
        } else if (newKey > current.key) {
            current.right = addRecursive(current.right, newKey);
        } else {
            return current;
        }

        return current;

    }

    private boolean containsRecursive(Node current, int searchKey) {

        if (current == null) {
            return false;
        }
        if (searchKey == current.key) {
            return true;
        }

        if (searchKey < current.key) {
            return containsRecursive(current.left, searchKey);
        } else {
            return containsRecursive(current.right, searchKey);
        }

    }

    private Node deleteRecursive(Node current, int deleteKey) {
        if (current == null) {
            return null;
        }

        if (deleteKey == current.key) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            int smallestValue = findSmallestValue(current.right);
            current.key = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (deleteKey < current.key) {
            current.left = deleteRecursive(current.left, deleteKey);
            return current;
        }
        current.right = deleteRecursive(current.right, deleteKey);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.key : findSmallestValue(root.left);
    }

    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    public boolean contains(int key) {
        return containsRecursive(root, key);
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public void inorder(Node current) {
        if (current != null) {
            inorder(current.left);
            System.out.println(current.key);
            inorder(current.right);
        }
    }

    public static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
        }

    }

    @Test
    public void testBST() {
        int[] arr = {7, 4, 1, 5, 8, 11};

        BinarySearchTree bt = new BinarySearchTree();
        Arrays.stream(arr).forEach(i -> bt.add(i));
        bt.inorder(bt.root);
        //bt.delete(4);
    }
}


