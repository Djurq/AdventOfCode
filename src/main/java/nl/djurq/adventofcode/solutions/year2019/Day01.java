//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package nl.djurq.adventofcode.solutions.year2019;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import nl.underkoen.adventofcode.solutions.Solution;

public class Day01 extends Solution {
    private final int day = 1;
    private final int year = 2019;

    public Day01() {
    }

    public long[] getCorrectOutput() {
        return new long[0];
    }

    protected void run(List<String> input) {
        this.a = 0L;
        this.b = 0L;

        Iterator var3 = input.iterator();

        while(var3.hasNext()) {
            String s = (String)var3.next();
            double mass = Double.parseDouble(s);
            double result = Math.floor(mass / 3.0D) - 2.0D;
            double massb = mass;
            this.a = (long)((double)this.a + result);
            System.out.println(mass);

            while(massb > 0.0D) {
                massb = Math.floor(massb / 3.0D) - 2.0D;
                System.out.println(this.b);
                if (massb > 0.0D) {
                    this.b = (long)((double)this.b + massb);
                }
            }
        }

    }

    public int getDay() {
        Objects.requireNonNull(this);
        return 1;
    }

    public int getYear() {
        Objects.requireNonNull(this);
        return 2019;
    }
}
