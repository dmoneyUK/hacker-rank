package leetcode.jpmorgan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class WordSearhOnBoard {
    
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
    
            char[][] board = {{'A', 'B', 'C', 'E'},
                              {'S', 'F', 'C', 'S'},
                              {'A', 'D', 'E', 'E'}};
            boolean[][] visited = new boolean[board.length][board[0].length];
            char[] input = line.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == input[0] && containsWord(board, input, i, j, 0, visited )) {
                        System.out.println("True");
                        return;
                    }
                }
            }
            System.out.println("False");
        }
    }
    
    private static boolean containsWord(char[][] board, char[] input, int row, int col, int index, boolean[][] visited) {
        if (index == input.length) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != input[index]) {
            return false;
        }
        visited[row][col] = true;
        
        if(containsWord(board, input, row-1, col, index+1, visited)
                ||containsWord(board, input, row+1, col, index+1, visited)
                ||containsWord(board, input, row, col-1, index+1, visited)
                ||containsWord(board, input, row, col+1, index+1, visited)){
            return true;
        }
        visited[row][col] =  false;
        return false;
    }
    
}
