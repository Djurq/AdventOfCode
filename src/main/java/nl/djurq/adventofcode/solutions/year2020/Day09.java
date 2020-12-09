package nl.djurq.adventofcode.solutions.year2020;

import lombok.Getter;
import nl.underkoen.adventofcode.solutions.Solution;

import java.util.ArrayList;
import java.util.List;

public class Day09 extends Solution {
    @Getter
    private final int day = 9;
    @Getter
    private final int year = 2020;

    @Override
    public long[] getCorrectOutput() {
        return new long[]{};
    }

    @Override
    protected void run(List<String> input) {
        List<Long> XMASNumbers = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            XMASNumbers.add(Long.parseLong(input.get(i)));
        }

        for(int i = 25, inputSize = input.size(); i < inputSize; i++) {
            long num = Long.parseLong(input.get(i));
            boolean goodNumber = false;

            ValidNumber: for (long num1 : XMASNumbers) {

                for (long num2 : XMASNumbers) {
                    long sum = num1 + num2;
                    if (sum == num) {
                        goodNumber = true;
                        break ValidNumber;
                    }
                }

            }
            if (!goodNumber){
                a = num;
                break;
            }
            XMASNumbers.remove(0);
            XMASNumbers.add(num);
        }
    }
}
