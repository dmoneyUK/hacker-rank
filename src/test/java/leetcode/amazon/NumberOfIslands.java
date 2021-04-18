package leetcode.amazon;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfIslands {
    
    @Test
    public void shouldReturn1() {
        
        char[][] grid = {{1,1,1,1,0}, {1,1,0,1,0}, {1,1,0,0,0}, {0,0,0,0,0}};
        
        assertThat(numIslands(grid)).isEqualTo(1);
        
    }
    
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numOfIslands = 0;
        int nr = grid.length;
        int nc = grid[0].length;
        
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == 1) {
                    numOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numOfIslands;
    }
    
    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0) {
            return;
        }
        grid[r][c] = 0;
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
