package leetcode.amazon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfIslandsII {
    
    @Test
    public void shouldReturn1() {
        
        int[][] grid = {{0, 0}, {1, 1}, {0, 1}};
        
        assertThat(numIslands2(2, 2, grid)).isEqualTo(Arrays.asList(1,2,1));
        
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> landToId = new HashMap<>();
        int islandId = 0;
        int numberOfIsland = 0;
        for (int[] pos : positions) {
            int r = pos[0];
            int c = pos[1];
            
            Set<Integer> overlap = new HashSet<>();
            if (r - 1 >= 0 && landToId.containsKey((r - 1) * n + c)) {
                overlap.add(landToId.get((r - 1) * n + c));
            }
            if (r + 1 < m && landToId.containsKey((r + 1) * n + c)) {
                overlap.add(landToId.get((r + 1) * n + c));
            }
            if (c - 1 >= 0 && landToId.containsKey(r * n + c - 1)) {
                overlap.add(landToId.get(r * n + c - 1));
            }
            if (c + 1 < n && landToId.containsKey(r * n + c + 1)) {
                overlap.add(landToId.get(r * n + c + 1));
            }
            
            if(overlap.isEmpty()){
                landToId.put(r * n + c, islandId++);
                numberOfIsland++;
            }else if(overlap.size()==1){
                landToId.put(r * n + c, overlap.iterator().next());
            }else{
                Integer rootId = overlap.iterator().next();
                landToId.forEach((key, value)-> {
                    
                    if(overlap.contains(value)){
                        landToId.put(key,rootId);
                    }
                });
                landToId.put(r*n+c, rootId);
                numberOfIsland -= overlap.size()-1;
            }
            ans.add(numberOfIsland);
        }
        
        return ans;
    }
}
