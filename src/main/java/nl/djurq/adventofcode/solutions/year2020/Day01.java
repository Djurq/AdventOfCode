package nl.djurq.adventofcode.solutions.year2020;

import lombok.Getter;
import nl.underkoen.adventofcode.solutions.Solution;

import java.util.List;

public class Day01 extends Solution {
    @Getter
    private final int day = 1;
    @Getter
    private final int year = 2020;

    @Override
    public long[] getCorrectOutput() {
        return new long[]{};
    }

    @Override
    protected void run(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            int number = Integer.parseInt(input.get(i));
            for (int j = 1; j < input.size(); j++) {
                int number2 = Integer.parseInt(input.get(j));
                int sum = number + number2;
                if (sum == 2020){
                    a = number * number2;
                }
                for (int k = 2; k < input.size(); k++) {
                    int number3 = Integer.parseInt(input.get(k));
                    int sum2 = number + number2 + number3;
                    if (sum2 == 2020){
                        b = number * number2 * number3;
                    }
                }
            }
        }

    }
}