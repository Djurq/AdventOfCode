//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package nl.djurq.adventofcode.solutions.year2019;

import java.util.List;
import java.util.Objects;
import nl.underkoen.adventofcode.solutions.Solution;

public class Day02 extends Solution {
    private final int day = 2;
    private final int year = 2019;

    public Day02() {
    }

    public long[] getCorrectOutput() {
        return new long[0];
    }

    protected void run(List<String> input) {
        int primaryNumber = 19690720;
        String OpCode = (String) input.get(0);
        String[] OpCodeStringArray = OpCode.split(",");

        OpCodeStringArray[1] = "12";
        OpCodeStringArray[2] = "2";
        for (int d = 0; d < 99; d++) {
            for (int c = 0; c < 99; c++) {
                Integer[] OpIntArray = new Integer[OpCodeStringArray.length];
                for (int i = 0; i < OpCodeStringArray.length; ++i) {
                    OpIntArray[i] = Integer.parseInt(OpCodeStringArray[i]);
                }
                OpIntArray[2] = d;
                OpIntArray[1] = c;
                int noun = c;
                int verb = d;
                for (int i = 0; i < OpIntArray.length; i += 4) {
                    if (OpIntArray[i] == 1) {
                        OpIntArray[OpIntArray[i + 3]] = OpIntArray[OpIntArray[i + 1]] + OpIntArray[OpIntArray[i + 2]];

                    } else if (OpIntArray[i] == 2) {

                        OpIntArray[OpIntArray[i + 3]] = OpIntArray[OpIntArray[i + 1]] * OpIntArray[OpIntArray[i + 2]];

                    } else if (OpIntArray[i] == 99) {
                        a = OpIntArray[0];
                        break;
                    }
                }

                a = OpIntArray[0];
                if ( a == primaryNumber){
                    b = (100 * noun) + verb;
                }
            }
        }
    }

    public int getDay() {
        Objects.requireNonNull(this);
        return 2;
    }

    public int getYear() {
        Objects.requireNonNull(this);
        return 2019;
    }
}
