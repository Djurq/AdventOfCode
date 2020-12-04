package nl.djurq.adventofcode.solutions.year2020;

import lombok.Getter;
import nl.underkoen.adventofcode.solutions.Solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04 extends Solution {
    @Getter
    private final int day = 4;
    @Getter
    private final int year = 2020;

    @Override
    public long[] getCorrectOutput() {
        return new long[]{};
    }

    @Override
    protected void run(List<String> input) {
        int k = 0;
        StringBuilder passwordString = new StringBuilder();
        Map<Integer, String> passports = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).isBlank()) {
                passports.put(k, passwordString.toString());
                k++;
                passwordString.setLength(0);
            }
            passwordString.append(input.get(i));
        }
        for (Integer integer : passports.keySet()){
            String passport = passports.get(integer);
            Pattern pattern1 = Pattern.compile("(byr:)");
            Matcher matcher1 = pattern1.matcher(passport);
            boolean matchFound1 = matcher1.find();

            Pattern pattern2 = Pattern.compile("(iyr:)");
            Matcher matcher2 = pattern2.matcher(passport);
            boolean matchFound2 = matcher2.find();

            Pattern pattern3 = Pattern.compile("(eyr:)");
            Matcher matcher3 = pattern3.matcher(passport);
            boolean matchFound3 = matcher3.find();

            Pattern pattern4 = Pattern.compile("(hgt:)");
            Matcher matcher4 = pattern4.matcher(passport);
            boolean matchFound4 = matcher4.find();

            Pattern pattern5 = Pattern.compile("(hcl:)");
            Matcher matcher5 = pattern5.matcher(passport);
            boolean matchFound5 = matcher5.find();

            Pattern pattern6 = Pattern.compile("(ecl:)");
            Matcher matcher6 = pattern6.matcher(passport);
            boolean matchFound6 = matcher6.find();

            Pattern pattern7 = Pattern.compile("(pid:)");
            Matcher matcher7 = pattern7.matcher(passport);
            boolean matchFound7 = matcher7.find();

            Pattern pattern8 = Pattern.compile("(cid:)");
            Matcher matcher8 = pattern8.matcher(passport);
            boolean matchFound8 = matcher8.find();

            if (matchFound1 && matchFound2 && matchFound3 && matchFound4 && matchFound5 && matchFound6 && matchFound7){
                a++;
            }
        }
    }
}