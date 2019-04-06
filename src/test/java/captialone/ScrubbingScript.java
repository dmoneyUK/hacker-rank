package captialone;

import java.util.Scanner;

public class ScrubbingScript {
    
    public static String END_MARKER = "</script>";
    public static String BEGIN_MARKER = "<script";
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String line = readNextLine(scan);
            if (line.contains(BEGIN_MARKER)) {
                line = line.substring(0, line.indexOf(BEGIN_MARKER));
                
                String next = "";
                while (scan.hasNext()) {
                    String s = readNextLine(scan);
                    if (s.contains(END_MARKER)) {
                        next = s.substring(next.indexOf(END_MARKER) + END_MARKER.length());
                        break;
                    }
                }
                line += next;
                System.out.println(line);
                
            }
        }
    }
    
    private static String readNextLine(Scanner scan) {
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        return scan.nextLine();
    }
    
}
