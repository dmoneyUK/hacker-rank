package leetcode.amazon.stringarray;

import org.junit.jupiter.api.Test;

public class IntegertoEnglishWords {
    
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                                           "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    @Test
    public void testPrint() {
        
        System.out.println(numberToWords(1000000));
    }
    
    public String numberToWords(int num) {
        String ans = "";
        if (num == 0) {
            return "Zero";
        }
        
        int i = 0;
        while (num > 0) {
            if(num%1000!=0){
                ans = convertHundreds(num % 1000) + THOUSANDS[i] + " " + ans;
            }
            i++;
            num = num / 1000;
        }
        
        return ans;
    }
    
    private String convertHundreds(int x) {
        if (x >= 100) {
            int hundred = x / 100;
            return LESS_THAN_20[hundred] + " Hundred " + convertHundreds(x % 100);
        } else if (x >= 20) {
            return TENS[x / 10] + " " + convertHundreds(x % 10);
        } else if(x>0){
            return LESS_THAN_20[x] + " ";
        }else{
            return "";
        }
    }
}
