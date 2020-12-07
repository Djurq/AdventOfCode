package nl.djurq.adventofcode.solutions.year2020;

import lombok.Getter;
import nl.underkoen.adventofcode.solutions.Solution;
import org.jgrapht.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day07 extends Solution {
    @Getter
    private final int day = 7;
    @Getter
    private final int year = 2020;

    @Override
    public long[] getCorrectOutput() {
        return new long[]{};
    }

    @Override
    protected void run(List<String> input) {
        input.add("");
        ArrayList<String> bags = new ArrayList<>();
        ArrayList<String> alreadyCheckedBags = new ArrayList<>();

        for (String s : input) {
            Pattern pattern1 = Pattern.compile("(\\d shiny gold)");
            Matcher matcher1 = pattern1.matcher(s);
            boolean matchFound = matcher1.find();
            if (matchFound) {
                a++;
                String[] bag = (s.split("bags", 2));
                String bag2 = bag[0];
                bags.add(bag2);
            }
        }
        System.out.println(bags);

        String removeBag = "";
        String addBag = "";
        String[] arrayBag = new String[0];
        while (!bags.isEmpty()) {
            for (String s : input) {
                for (int i = 0, bagsSize = bags.size(); i < bagsSize; i++) {
                    String bag = bags.get(i);
                    Pattern pattern1 = Pattern.compile("(\\d "+bag+")");
                    Matcher matcher1 = pattern1.matcher(s);
                    boolean matchFound = matcher1.find();
                    if (matchFound && !alreadyCheckedBags.contains(bag)) {
                        removeBag = bag;
                        alreadyCheckedBags.add(bag);
                        String[] bag3 = (s.split(" bags?,? ?\\.?(?:contain )?"));
                        a++;
                        bags.add(bag3[0]);
                        bags.remove(removeBag);
                    }
                }
                System.out.println(bags);
            }
        }
    }
}