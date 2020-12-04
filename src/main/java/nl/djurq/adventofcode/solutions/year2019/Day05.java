package nl.djurq.adventofcode.solutions.year2019;

import lombok.Getter;
import nl.underkoen.adventofcode.solutions.Solution;

import java.util.List;

public class Day05 extends Solution {
    @Getter
    private final int day = 5;
    @Getter
    private final int year = 2019;

    @Override
    public long[] getCorrectOutput() {
        return new long[]{};
    }

    @Override
    protected void run(List<String> input) {
        String OpCode = input.get(0);
        String[] OpCodeStringArray = OpCode.split(",");
        int input1 = 1;
        OpCodeStringArray[1] = "12";
        OpCodeStringArray[2] = "2";
        for (int d = 0; d < 99; d++) {
            for (int c = 0; c < 99; c++) {
                Integer[] OpIntArray = new Integer[OpCodeStringArray.length];
                for (int i = 0; i < OpCodeStringArray.length; ++i) {
                    OpIntArray[i] = Integer.parseInt(OpCodeStringArray[i]);
                }
                for (int i = 0; i < OpIntArray.length; i += 4) {
                    if (OpIntArray[i] == 1) {
                        OpIntArray[OpIntArray[i + 3]] = OpIntArray[OpIntArray[i + 1]] + OpIntArray[OpIntArray[i + 2]];

                    } else if (OpIntArray[i] == 2) {

                        OpIntArray[OpIntArray[i + 3]] = OpIntArray[OpIntArray[i + 1]] * OpIntArray[OpIntArray[i + 2]];

                    } else if (OpIntArray[i] == 3) {

                    } else if (OpIntArray[i] == 4) {
                        //output console
                    } else if (OpIntArray[i] == 99) {
                        a = OpIntArray[0];
                        break;
                    }
                }
            }
        }
    }
}