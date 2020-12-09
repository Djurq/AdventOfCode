package nl.djurq.adventofcode.solutions.year2020;

import com.google.common.collect.HashBiMap;
import lombok.Getter;
import nl.underkoen.adventofcode.solutions.Solution;
import org.jgrapht.Graph;

import java.util.*;
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

    public void loop(String tas) {

    }

    @Override
    protected void run(List<String> input) {
        Map<String, List<String>> bags = new HashMap<>();
        List<String> bagWithShinyGold = new ArrayList<>();
        List<String> alreadyCheckedBags = new ArrayList<>();

        for (String s : input) {
            String[] bag = s.split(" bags?,? ?\\.?(?:contain )?");
            ArrayList<String> otherBags1 = new ArrayList<>();
            for (int i = 1; i < bag.length; i++) {
                if (bag[0].equals("shiny gold")) {
                    continue;
                }
                if (bag[i].equals("no other")) {
                    otherBags1.add(bag[i]);
                } else {
                    otherBags1.add(bag[i].substring(2));
                }
                bags.put(bag[0], otherBags1);
            }
        }

        for (Map.Entry<String, List<String>> colorSet : bags.entrySet()) {
            for (String s : colorSet.getValue()) {
                if (s.equals("shiny gold") && !bagWithShinyGold.contains(colorSet.getKey())) {
                    alreadyCheckedBags.add(colorSet.getKey());
                    bagWithShinyGold.add(colorSet.getKey());
                    a += 1;
                }
            }
        }

    }
}

