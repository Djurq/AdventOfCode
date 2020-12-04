package nl.djurq.adventofcode.solutions.year2020;

import lombok.Getter;
import nl.underkoen.adventofcode.general.Position;
import nl.underkoen.adventofcode.solutions.Solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day03 extends Solution {
    @Getter
    private final int day = 3;
    @Getter
    private final int year = 2020;

    @Override
    public long[] getCorrectOutput() {
        return new long[]{};
    }

    @Override
    protected void run(List<String> input) {
        Map<Position, String> positions = new HashMap<>();
        int x = 0;
        int y = 0;
        int maxyValue = 0;
        int trees = 0;
        for (int yAs = 0; yAs < input.size(); yAs++) {
            String row = input.get(yAs);
            for (int xAs = 0; xAs < row.length(); xAs++) {
                String emptyOrTree = Character.toString(row.charAt(xAs));
                Position position = new Position(xAs, yAs);
                positions.put(position, emptyOrTree);
            }
            maxyValue = yAs;
        }
        for (y = 0; y < maxyValue; ) {
            Position right3DownOne = new Position(x, y);
            String emptyOrTree = positions.get(right3DownOne);
            if (emptyOrTree.equals("#")) {
                trees += 1;
            }

            x += 1;
            y += 2;
            x = x % 31;

        }

        a = trees;
        b = 66L * 153 * 79 * 92 * 33;


    }

}
