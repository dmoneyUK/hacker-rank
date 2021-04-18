package interviews.JPMorgan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/*
Type Ahead
Programming challenge description:
Your task is to build a type-ahead feature for an upcoming product.

When the user enters a word or set of words, we want to be able to "predict" what they're going to type next with some level of accuracy. We've chosen to implement this using the N-Gram algorithm defined here http://en.wikipedia.org/wiki/N-gram.

Your program should return a tuple of predictions sorted high to low based on the prediction score (up to a maximum of three decimal places, or pad with zeroes up to three decimal places i.e. 0.2 should be shown as 0.200), (if predictions share the same score, they are sorted alphabetically.) Words should be split by whitespace with all non-alphanumeric characters stripped off the beginning and end.

Prediction scores are calculated like this:
Occurrences of a word after an N-gram / total number of words after an N-gram
e.g. for an N-gram of length 2:
ONE TWO ONE TWO THREE TWO THREE
"TWO" has the following predictions:
THREE:0.666,ONE:0.333
"THREE" occurred 2 times after a "TWO" and "ONE" occurred 1 time after a "TWO", for a total of 3 occurrences after a "TWO".

Your program will run against the following text. You may hardcode it into your program:
Mary had a little lamb its fleece was white as snow;
And everywhere that Mary went, the lamb was sure to go.
It followed her to school one day, which was against the rule;
It made the children laugh and play, to see a lamb at school.
And so the teacher turned it out, but still it lingered near,
And waited patiently about till Mary did appear.
"Why does the lamb love Mary so?" the eager children cry;"Why, Mary loves the lamb, you know" the teacher did reply."
Input:
Your program should read lines of text from standard input. Each line contains a number followed by a string, separated by a comma. The number is the n-gram length. The string is the text from the user. You will be predicting the text following this string.
Output:
For each line of input print a single line to standard output which is the predictions for what the user is going to type next.
Test 1
Test Input
Download Test 1 Input
2,the
Expected Output
Download Test 1 Input
lamb,0.375;teacher,0.250;children,0.125;eager,0.125;rule,0.125
 */
public class NgramPredicate {

    @Test
    public void testSample2() {

    }

    static String text =
        "Mary had a little lamb its fleece was white as snow;\n" +
            "And everywhere that Mary went, the lamb was sure to go.\n" +
            "It followed her to school one day, which was against the rule;\n" +
            "It made the children laugh and play, to see a lamb at school.\n" +
            "And so the teacher turned it out, but still it lingered near,\n" +
            "And waited patiently about till Mary did appear.\n" +
            "\"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.\"";

    public static void main(String[] args) throws IOException {
//        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//        BufferedReader in = new BufferedReader(reader);
        String[] lines = text.split("\n");

        int ngram = Integer.valueOf(args[0]);
        String input = args[1];

        List<List<String>> allMatches = new ArrayList<>();
        int total = 0;

        for (String line : lines) {
            int indexInLine = 0;
            String[] wordsInLine = line.split(" ");
            List<String> matchesInLine = new ArrayList<>();
            for (String w : wordsInLine) {
                if (w.equals(input) && indexInLine <= wordsInLine.length - ngram) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 1; j < ngram - 1; j++) {
                        String normalizedWord = normalizeString(wordsInLine[indexInLine + j]);
                        sb.append(normalizedWord);
                        sb.append(" ");
                    }
                    sb.append(normalizeString(wordsInLine[indexInLine + ngram - 1]));
                    matchesInLine.add(sb.toString());
                    total++;
                }
                indexInLine++;
            }
            allMatches.add(matchesInLine);
        }

        int finalTotal = total;

        String output = allMatches.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .map(entry -> entry.getKey() + "," + BigDecimal.valueOf(entry.getValue()).divide(BigDecimal.valueOf(finalTotal)).setScale(3, RoundingMode.HALF_UP) + ";")
            .collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));

        System.out.println(output);
    }

    private static String normalizeString(String s) {
        return s.chars()
            .filter(c -> Character.isLetter(c))
            .mapToObj(c -> (char) c).collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));
    }
}
