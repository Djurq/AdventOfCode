package nl.djurq.adventofcode.solutions.year2019;

import lombok.Getter;
import nl.underkoen.adventofcode.general.Position;
import nl.underkoen.adventofcode.solutions.Solution;

import java.util.*;

public class Day03 extends Solution {
    @Getter
    private final int day = 3;
    @Getter
    private final int year = 2019;

    @Override
    public long[] getCorrectOutput() {
        return new long[]{};
    }

    @Override
    protected void run(List<String> input) {
        Map<Position, Integer> wire1 = new HashMap<>();
        Map<Position, Integer> wire2 = new HashMap<>();
        HashSet<Position> samePositions = new HashSet<>();


        String[] instructionsWire1 = input.get(0).split(",");
        String[] instructionsWire2 = input.get(1).split(",");

        int xCoordWire1 = 0;
        int yCoordWire1 = 0;

        int xCoordWire2 = 0;
        int yCoordWire2 = 0;

        int stepsWire1 = 1;
        for (String s : instructionsWire1) {
            char direction = s.charAt(0);
            int maxLengthString = s.length();
            int movement = Integer.parseInt(s.substring(1, maxLengthString));
            if (direction == 'L') {


                for ( int i1 = 0;i1 < movement; i1++) {
                    xCoordWire1 -= 1;
                    Position Wire1 = new Position(xCoordWire1, yCoordWire1);
                    wire1.put(Wire1, stepsWire1);
                    stepsWire1++;
                }
            }

            if (direction == 'R') {

                for (int i1 = 0; i1 < movement; i1++) {
                    xCoordWire1 += 1;
                    Position Wire1 = new Position(xCoordWire1, yCoordWire1);
                    wire1.put(Wire1, stepsWire1);
                    stepsWire1++;

                }
            }

            if (direction == 'D') {

                for ( int i1 = 0; i1 < movement; i1++) {
                    yCoordWire1 -= 1;
                    Position Wire1 = new Position(xCoordWire1, yCoordWire1);
                    wire1.put(Wire1, stepsWire1);
                    stepsWire1++;
                }

            }

            if (direction == 'U') {

                for ( int i1 = 0; i1 < movement; i1++) {
                    yCoordWire1 += 1;
                    Position Wire1 = new Position(xCoordWire1, yCoordWire1);
                    wire1.put(Wire1, stepsWire1);
                    stepsWire1++;
                }

            }
        }
        int stepsWire2 = 1;
        for (String s : instructionsWire2) {
                char direction = s.charAt(0);
                int maxLengthString = s.length();
                int movement = Integer.parseInt(s.substring(1, maxLengthString));


                if (direction == 'L') {

                for ( int j1 = 0; j1 < movement; j1++) {
                    xCoordWire2 -= 1;
                    Position Wire2 = new Position(xCoordWire2, yCoordWire2);
                    wire2.put(Wire2, stepsWire2);
                    stepsWire2++;
                }
            }

            if (direction == 'R') {

                for ( int j1 = 0; j1 < movement; j1++) {
                    xCoordWire2 += 1;
                    Position Wire2 = new Position(xCoordWire2, yCoordWire2);
                    wire2.put(Wire2, stepsWire2);
                    stepsWire2++;
                }
            }

            if (direction == 'D') {

                for ( int j1 = 0; j1 < movement; j1++) {
                    yCoordWire2 -= 1;
                    Position Wire2 = new Position(xCoordWire2, yCoordWire2);
                    wire2.put(Wire2, stepsWire2);
                    stepsWire2++;
                }

            }

            if (direction == 'U') {

                for ( int j1 = 0; j1 < movement; j1++) {
                    yCoordWire2 += 1;
                    Position Wire2 = new Position(xCoordWire2, yCoordWire2);
                    wire2.put(Wire2, stepsWire2);
                    stepsWire2++;
                }

            }

        }
            b = 1000000;
        for (Position position : wire1.keySet()) {
            if (wire2.containsKey(position)) {
                samePositions.add(position);

                Integer steps = wire2.get(position) + wire1.get(position);
                System.out.println(steps);
                if (steps < b){
                    b = steps;
                }

            }
        }
        a = samePositions.stream()
                .mapToLong(Position::distanceOrigin).min().orElse(69);


    }
}