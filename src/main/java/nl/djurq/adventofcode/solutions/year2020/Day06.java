package nl.djurq.adventofcode.solutions.year2020;

import lombok.Getter;
import nl.underkoen.adventofcode.solutions.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Day06 extends Solution {
    @Getter
    private final int day = 6;
    @Getter
    private final int year = 2020;

    @Override
    public long[] getCorrectOutput() {
        return new long[]{};
    }

    public static int countUniqueChars(String buf) {
        HashSet<Character> hash = new HashSet<>();
        buf = buf.toUpperCase();
        for (int i = 0; i < buf.length(); i++)
            hash.add(buf.charAt(i));
        return hash.size();
    }

    @Override
    protected void run(List<String> input) {
        input.add("");
        StringBuilder questions = new StringBuilder();
        HashSet<Character> hash = new HashSet<>();
        ArrayList<String> answers = new ArrayList<>();
        int count = 0;
        int countSameCharacter = 0;


        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).isBlank()) {
                for (int j = 0; j < questions.length(); j++) {
                    hash.add(questions.charAt(j));
                }
                for (Character character : hash) {

                    for (String answer : answers) {
                        if (answer.contains("" + character)) {
                            count++;
                        }
                    }
                    if (count >= answers.size()) {
                        countSameCharacter++;
                    }
                    count = 0;
                }
                int size = hash.size();
                a += size;
                b += countSameCharacter;
                countSameCharacter = 0;
                answers.clear();
                questions.setLength(0);
                hash.clear();
                continue;

            }
            answers.add(input.get(i));
            questions.append(input.get(i));
        }


    }

}
