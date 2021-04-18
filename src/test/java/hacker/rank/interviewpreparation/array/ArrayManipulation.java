package hacker.rank.interviewpreparation.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayManipulation {

    @Test
    public void testArrayManipulation() {
        int n = 5;
        int[][] queries = {{1, 2, 100}, {2, 5, 100}, {3, 4, 100}};
        long[] diffs = new long[n+1];

        for (int i = 0; i < queries.length; i++) {
            diffs[queries[i][0] - 1] += queries[i][2];
            diffs[queries[i][1]] -= queries[i][2];
        }

        long[] arr = new long[diffs.length-1];
        arr[0] = diffs[0];

        for (int i = 1; i < diffs.length-1; i++) {
            arr[i] = arr[i - 1] + diffs[i];
        }

        printArray(arr);

        long max = 0;
        long temp = 0;
        for(int i=0;i<n;i++){
            temp += diffs[i];
            if(temp>max){
                max = temp;
            }
        }

        System.out.println(max);

    }

    public static void main(String[] args) {
        int n = 5;
        int[][] queries = {{1, 2, 100}, {2, 5, 100}, {3, 4, 100}};
        long[] arr = new long[n];

        printArray(arr);
        for (int[] op : queries) {
            int begin = op[0] - 1;
            int end = op[1] - 1;
            int value = 100;
            for (int index = begin; index <= end; index++) {
                arr[index] += value;
            }
            printArray(arr);
        }

        System.out.println(findMax(arr));
    }

    private static void printArray(long arr[]) {
        System.out.print("[");
        for (long i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }

    private static long findMax(long[] arr) {
        return new BST(arr).getMax();
    }

    static class BST {
        Node root;

        BST(long[] arr) {
            Arrays.stream(arr)
                  .forEach(e -> root = addRecursive(root, e));
        }

        long getMax() {
            return getRightRecursive(root).value;
        }

        Node getRightRecursive(Node current) {
            if (current.right == null) {
                return current;
            }
            return getRightRecursive(current.right);
        }

        private Node addRecursive(Node current, long newValue) {
            Node newNode = new Node(newValue);
            if (current == null) {
                return newNode;
            }

            if (current.value > newValue) {
                current.left = addRecursive(current.left, newValue);
            } else if (current.value < newValue) {
                current.right = addRecursive(current.right, newValue);
            } else {
                return current;
            }
            return current;

        }
    }

    static class Node {
        long value;
        Node left, right;

        Node(long value) {
            this.value = value;
        }
    }
}
