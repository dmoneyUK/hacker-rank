package captialone;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class FizzBuzz {
    
    public static void main(String[] args) {
        IntStream.range(1, 100).mapToObj(i -> {
            String s = String.valueOf(i);
            if (i % 15 == 0) {
                s = "FizzBuzz";
            } else if (i % 3 == 0) {
                s = "Fizz";
            } else if (i % 5 == 0) {
                s = "Buzz";
            }
            System.out.println(s);
            return s;
        }).collect(toList());
    }
}
    
    //Scanner scan = new Scanner(System.in);
    //int n = scan.nextInt();
    //for(int i=1; i<=n; i++){
    //        String ans = String.valueOf(i);
    //        if(i%15==0){
    //        ans = "FizzBuzz";
    //        }else if(i%3==0){
    //        ans = "Fizz";
    //        }else if(i%5==0){
    //        ans = "Buzz";
    //        }
    //        System.out.println(ans);
    //        }
