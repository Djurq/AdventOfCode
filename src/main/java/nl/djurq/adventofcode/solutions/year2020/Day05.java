package nl.djurq.adventofcode.solutions.year2020;

import lombok.Getter;
import nl.underkoen.adventofcode.solutions.Solution;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Day05 extends Solution {
    @Getter
    private final int day = 5;
    @Getter
    private final int year = 2020;

    @Override
    public long[] getCorrectOutput() {
        return new long[]{};
    }

    @Override
    protected void run(List<String> input) {
        HashSet<Integer> seats = new HashSet<>();
        for (String s : input) {
            int highestRow = 127;
            int lowestRow = 0;
            int yourRow = 0;
            int currentRange = 0;
            int change = 0;
            int highestColumn = 7;
            int lowestColumn = 0;
            int yourColumn = 0;
            int currentRangeColumn = 0;
            int changeColumn = 0;
            int seatID = 0;
            for (int i = 0; i < s.length(); i++) {
                Character FBRL = s.charAt(i);
                if (i <= 6) {
                    currentRange = highestRow - lowestRow;
                    if (i == 6 && FBRL.equals('F')) {
                        yourRow = lowestRow;
                    } else if (FBRL.equals('F')) {
                        change = (int) Math.ceil(currentRange / 2.0);
                        highestRow = highestRow - change;
                    }
                    if (i == 6 && FBRL.equals('B')) {
                        yourRow = highestRow;
                    } else if (FBRL.equals('B')) {
                        change = (int) Math.ceil(currentRange / 2.0);
                        lowestRow = lowestRow + change;
                    }

                }
                if (i > 6 && i <= 9) {
                    currentRangeColumn = highestColumn - lowestColumn;
                    if (i == 9 && FBRL.equals('L')) {
                        yourColumn = lowestColumn;
                    } else if (FBRL.equals('L')) {
                        changeColumn = (int) Math.ceil(currentRangeColumn / 2.0);
                        highestColumn = highestColumn - changeColumn;
                    }
                    if (i == 9 && FBRL.equals('R')) {
                        yourColumn = highestColumn;
                    } else if (FBRL.equals('R')) {
                        changeColumn = (int) Math.ceil(currentRangeColumn / 2.0);
                        lowestColumn = lowestColumn + changeColumn;
                    }
                }
                if (i == 9) {
                    seatID = ((yourRow * 8) + yourColumn);
                    seats.add(seatID);
                    if (seatID > a) {
                        a = seatID;
                    }
                }
            }
        }
        for (Integer seat : seats) {
            if (!(seats.contains(seat+1))){
                System.out.println(seat+1);
            }
            if (!(seats.contains(seat-1))){
                System.out.println(seat-1);
            }
        }
    }
}