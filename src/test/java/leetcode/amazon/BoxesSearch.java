package leetcode.amazon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BoxesSearch {
    
    @Test
    public void test() {
        
        List<String> l = new ArrayList<>();
        //l.add("min2 jog mid pet");
        //l.add("wz3 34 54 398");
        //l.add("a1 alps cow bar");
        //l.add("x4 45 21 7");
        
        List<String> order = order(0, null);
        order.stream().forEach(System.out::println);
    }
    
    public List<String> order(int numberOfBoxes, List<String> boxList) {
        
        if(numberOfBoxes<0 || boxList==null){
            return null;
        }
        
        List<String> oldBoxes = boxList.stream()
                                       .filter(s -> !isNewVersion(s))
                                       .sorted(Comparator.comparing(this::getVersion)
                                                         .thenComparing(Comparator.comparing(this::getId)))
                                       .collect(Collectors.toList());
    
        List<String> newBoxes = boxList.stream()
                                       .filter(s -> isNewVersion(s))
                                       .collect(Collectors.toList());
        
        oldBoxes.addAll(newBoxes);
        return oldBoxes;
    }
    
    private String getId(String s) {
        return s.substring(0, s.indexOf(" "));
    }
    
    private String getVersion(String s) {
        return s.substring(s.indexOf(" ") + 1);
    }
    
    private boolean isNewVersion(String s) {
        String[] subs = s.split(" ");
        boolean isNewVersion = true;
        for (int i = 1; i < subs.length; i++) {
            try {
                Integer.valueOf(subs[i]);
            } catch (NumberFormatException ex) {
                isNewVersion = false;
                break;
            }
        }
        return isNewVersion;
    }
}
