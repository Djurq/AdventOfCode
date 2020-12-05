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
        return new long[]{196,114};
    }

    @Override
    protected void run(List<String> input) {
        input.add("");
        boolean byr = false;
        boolean iyr = false;
        boolean eyr = false;
        boolean hgt = false;
        boolean hcl = false;
        boolean ecl = false;
        boolean pid = false;
        int k = 0;
        StringBuilder passwordString = new StringBuilder();
        Map<Integer, String> passports = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).isBlank()) {
                passports.put(k, passwordString.toString());
                k++;
                passwordString.setLength(0);
            }
            passwordString.append(" ").append(input.get(i));
        }
        for (String passport : passports.values()) {
            Pattern pattern1 = Pattern.compile("(byr:)");
            Matcher matcher1 = pattern1.matcher(passport);
            boolean matchFound1 = matcher1.find();
            if (matchFound1) {
                String[] iets = passport.split(pattern1.toString());
                String jaar = iets[1].substring(0, 4);
                if (Integer.parseInt(jaar) >= 1920 && Integer.parseInt(jaar) <= 2002) {
                    byr = true;
                }
            }

            Pattern pattern2 = Pattern.compile("(iyr:)");
            Matcher matcher2 = pattern2.matcher(passport);
            boolean matchFound2 = matcher2.find();
            if (matchFound2) {
                String[] iets = passport.split(pattern2.toString());
                String jaar = iets[1].substring(0, 4);
                if (Integer.parseInt(jaar) >= 2010 && Integer.parseInt(jaar) <= 2020) {
                    iyr = true;

                }
            }

            Pattern pattern3 = Pattern.compile("(eyr:)");
            Matcher matcher3 = pattern3.matcher(passport);
            boolean matchFound3 = matcher3.find();
            if (matchFound3) {
                String[] iets = passport.split(pattern3.toString());
                String jaar = iets[1].substring(0, 4);
                if (Integer.parseInt(jaar) >= 2020 && Integer.parseInt(jaar) <= 2030) {
                    eyr = true;

                }
            }

            Pattern pattern4 = Pattern.compile("(hgt:)");
            Matcher matcher4 = pattern4.matcher(passport);
            boolean matchFound4 = matcher4.find();

            if (matchFound4) {
                String[] iets = passport.split(pattern4.toString());
                String jaar = iets[1].substring(0, 4);

                Pattern pattern9 = Pattern.compile("(c)");
                Matcher matcher9 = pattern9.matcher(jaar);
                boolean matchFound9 = matcher9.find();
                if (matchFound9) {
                    String[] height = jaar.split("(c)");
                    if (Integer.parseInt(height[0]) >= 150 && Integer.parseInt(height[0]) <= 193) {
                        hgt = true;
                    }
                }

                Pattern pattern10 = Pattern.compile("(i)");
                Matcher matcher10 = pattern10.matcher(jaar);
                boolean matchFound10 = matcher10.find();
                if (matchFound10) {
                    String[] height = jaar.split("(i)");
                    height[0] = height[0].trim();
                    if (Integer.parseInt(height[0]) >= 59 && Integer.parseInt(height[0]) <= 76) {
                        hgt = true;

                    }
                }
            }

            Pattern pattern5 = Pattern.compile("(hcl:)");
            Matcher matcher5 = pattern5.matcher(passport);
            boolean matchFound5 = matcher5.find();

            if (matchFound5) {
                String[] iets = passport.split(pattern5.toString());
                String jaar = iets[1];

                Pattern pattern11 = Pattern.compile("#([a-fA-F0-9]{6})");
                Matcher matcher11 = pattern11.matcher(jaar);
                boolean matchFound11 = matcher11.find();
                if (matchFound11) {
                    hcl = true;

                }
            }


            Pattern pattern6 = Pattern.compile("(ecl:)");
            Matcher matcher6 = pattern6.matcher(passport);
            boolean matchFound6 = matcher6.find();
            if (matchFound6) {
                String[] iets = passport.split(pattern6.toString());
                String jaar = iets[1];

                Pattern pattern12 = Pattern.compile("(amb|blu|brn|gry|grn|hzl|oth)");
                Matcher matcher12 = pattern12.matcher(jaar);
                boolean matchFound12 = matcher12.find();
                if (matchFound12) {
                    ecl = true;
                }
            }

            Pattern pattern7 = Pattern.compile("(pid:)");
            Matcher matcher7 = pattern7.matcher(passport);
            boolean matchFound7 = matcher7.find();

            if (matchFound7) {
                String[] iets = passport.split(pattern7.toString());
                String jaar = iets[1];
                Pattern pattern11 = Pattern.compile("^\\d{9}($| )");
                System.out.println(jaar);
                Matcher matcher11 = pattern11.matcher(jaar);
                boolean matchFound11 = matcher11.find();
                if (matchFound11) {
                    pid = true;
                }
            }
            if (matchFound1 && matchFound2 && matchFound3 && matchFound4 && matchFound5 && matchFound6 && matchFound7) {
                a++;
            }

            if (byr && iyr && eyr && hgt && hcl && ecl && pid) {
                b++;
            }
            byr = false;
            iyr = false;
            eyr = false;
            hgt = false;
            hcl = false;
            ecl = false;
            pid = false;
        }
    }
}
