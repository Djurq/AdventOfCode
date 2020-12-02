package nl.djurq.adventofcode.solutions.year2020;

import lombok.Getter;
import nl.underkoen.adventofcode.solutions.Solution;
import org.w3c.dom.ranges.Range;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02 extends Solution {
    @Getter
    private final int day = 2;
    @Getter
    private final int year = 2020;

    @Override
    public long[] getCorrectOutput() {
        return new long[]{};
    }

    @Override
    protected void run(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            String[] parts = input.get(i).split(":|[-]");
            String password = parts[1];
            String[] minMaxLetter = parts[0].split(" ");
            char letter = minMaxLetter[1].charAt(0);
            String[] minMax = minMaxLetter[0].split("-");
            int min = Integer.parseInt(minMax[0]);
            int max = Integer.parseInt(minMax[1]);
            int letterFrequency = 0;
            char position1 = password.charAt(min);
            char position2 = password.charAt(max);
            for (int j = 0; j < password.length(); j++) {
                if (password.charAt(j) == letter) {
                    letterFrequency++;
                }
            }
            if (position1 == letter && position2 == letter){

            }else if (position1 != letter && position2 != letter){

            }else {
                b++;
            }
            if (letterFrequency >= min && letterFrequency <= max) {
                a++;
            }



        }


    }
}