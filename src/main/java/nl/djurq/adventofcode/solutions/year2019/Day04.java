package nl.djurq.adventofcode.solutions.year2019;

import lombok.Getter;
import nl.underkoen.adventofcode.solutions.Solution;
import org.checkerframework.checker.regex.qual.Regex;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04 extends Solution {
    @Getter
    private final int day = 4;
    @Getter
    private final int year = 2019;

    @Override
    public long[] getCorrectOutput() {
        return new long[]{};
    }

    @Override
    protected void run(List<String> input) {
        //6 digits
        // between 197487-673251
        // Two adjacent digits are the same (like 22 in 122345)
        // Going from left to right, the digits never decrease;
        // they only ever increase or stay the same (like 111123 or 135679).
        int beginDigit = 197487;
        int endDigit = 673251;
        int possibleCombinations = 0;
        int possibleCombinations2 = 0;
        while (beginDigit != endDigit) {
            Pattern pattern = Pattern.compile("(\\d)\\1");
            String beginDigitString = Integer.toString(beginDigit);
            Matcher matcher = pattern.matcher(beginDigitString);
            boolean matchFound = matcher.find();

            Pattern pattern2 = Pattern.compile("(\\d)\\1");
            Matcher matcher2 = pattern2.matcher(beginDigitString);
            boolean matchFound2 = matcher2.find();


            if (matchFound) {
                char[] digitArray = beginDigitString.toCharArray();
                if (digitArray[0] > digitArray[1] || digitArray[1] > digitArray[2] || digitArray[2] > digitArray[3] || digitArray[3] > digitArray[4] || digitArray[4] > digitArray[5]) {

                } else {
                    possibleCombinations++;
                    if (matchFound2) {
                        String a = beginDigitString;
                        String pattern3 = "(\\d)\\1{2,5}";
                        a = a.replaceAll(pattern3, "");

                        Pattern pattern4 = Pattern.compile("(\\d)\\1");
                        Matcher matcher3 = pattern4.matcher(a);
                        boolean matchFound3 = matcher3.find();

                        if (matchFound3) {
                            possibleCombinations2++;
                        }

                    }

                    else {
                        possibleCombinations2++;
                    }
                }

            }
            beginDigit++;
        }

        a = possibleCombinations;
        b = possibleCombinations2;

    }
}