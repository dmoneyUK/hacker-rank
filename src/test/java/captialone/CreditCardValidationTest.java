package captialone;

import java.util.Scanner;

public class CreditCardValidationTest {
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (scan.hasNext()) {
            scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String line = scan.nextLine();
            long[] reversedNumber = getReversedCardNumber(line);
  
            boolean isValid = verifyCheckSum(reversedNumber);
            System.out.println(isValid);
            System.out.println();
        }
        
    }
    
    private static long[] getReversedCardNumber(String line) {
        long cardNumber = Long.parseLong(line);
        long[] reversedNumber = new long[16];
        for (int i = 0; i < 16; i++) {
            long remaining = cardNumber % 10;
            reversedNumber[i] = remaining;
            cardNumber /= 10;
        }
        return reversedNumber;
    }
    
    private static boolean verifyCheckSum(long[] numbers) {
        long sumOfOdd = getSumOfOdd(numbers);
        
        long sumOfEven = getSumOfEven(numbers);
        
        return (sumOfOdd + sumOfEven) % 10 == 0;
    }
    
    private static long getSumOfEven(long[] numbers) {
        long sum = 0;
        for (int i = 1; i < 16; i += 2) {
            long value = numbers[i] * 2;
            if (value > 9) {
                sum += value % 10 + value / 10;
            } else {
                sum += value;
            }
        }
        return sum;
    }
    
    private static long getSumOfOdd(long[] numbers) {
        int sum = 0;
        for (int i = 0; i < 16; i += 2) {
            sum += numbers[i];
        }
        return sum;
    }
}
