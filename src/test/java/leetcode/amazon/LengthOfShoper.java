package leetcode.amazon;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LengthOfShoper {
    
    @Test
    public void testSample3() {
        ArrayList<Character> list = Lists.list('z', 'z', 'c', 'b', 'z', 'c', 'h', 'f', 'i', 'h', 'i');
        
        List<Integer> integers = lengthOfShoper2(list);
        
        integers.stream().forEach(System.out::println);
    }
    
    @Test
    public void testSample1() {
        ArrayList<Character> list = Lists.list('a', 'b', 'c', 'a');
        
        List<Integer> integers = lengthOfShoper2(list);
        
        integers.stream().forEach(System.out::println);
    }
    
    public List<Integer> lengthOfShoper2(List<Character> inputList) {
        List<Integer> ans = new ArrayList<>();
        int begin = 0;
        while (begin < inputList.size()) {
            int last = inputList.lastIndexOf(inputList.get(begin));
            
            if (last != begin) {
                for (int i = begin; i < last; i++) {
                    int newLast = inputList.lastIndexOf(inputList.get(i));
                    if (newLast != i) {
                        last = Math.max(last, newLast);
                    }
                }
                ans.add(last - begin + 1);
            } else {
                ans.add(1);
            }
            begin = last + 1;
        }
        return ans;
        
    }
    
    public List<Integer> lengthOfShoper(List<Character> inputList) {
        int freq[] = new int[26];
        List<Integer> ans = new ArrayList<>();
        
        inputList.stream().forEach(c -> freq[c - 'a']++);
        int begin = 0;
        for (int i = 0; i < inputList.size(); i++) {
            if (freq[inputList.get(i) - 'a'] == 1) {
                ans.add(i - begin + 1);
                begin = i + 1;
            }
        }
        
        return ans;
        
    }
}
