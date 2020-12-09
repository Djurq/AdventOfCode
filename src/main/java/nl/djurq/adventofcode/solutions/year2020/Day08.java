package nl.djurq.adventofcode.solutions.year2020;

import lombok.Getter;
import nl.underkoen.adventofcode.solutions.Solution;

import java.util.ArrayList;
import java.util.List;

public class Day08 extends Solution {
    @Getter
    private final int day = 8;
    @Getter
    private final int year = 2020;

    @Override
    public long[] getCorrectOutput() {
        return new long[]{};
    }

    @Override
    protected void run(List<String> input) {
        List<Instruction> instructions = new ArrayList<>();
        List<Integer> alreadyPerformedInstructions = new ArrayList<>();
        List<Instruction> instructionsCopie = new ArrayList<>();
        List<Integer> positionJumps = new ArrayList<>();
        List<Integer> positionNops = new ArrayList<>();

        int counter = 0;
        int counterNops = 0;
        int counterJmps = 0;


        for (String s : input) {
            String[] strings = s.split(" ");
            Instruction instruction = new Instruction(strings[0], Integer.parseInt(strings[1]), counter);
            instructions.add(instruction);
            instructionsCopie.add(instruction);
            if (strings[0].equals("nop")) {
                positionNops.add(counter);
                counterNops++;
            }

            if (strings[0].equals("jmp")) {
                positionJumps.add(counter);
                counterJmps++;
            }
            counter++;
        }
        System.out.println(counterJmps);
        System.out.println(counterNops);
        System.out.println();
        boolean breakie;

        for (int j = 0; j < positionJumps.size(); j++) {
            instructions = new ArrayList<>(instructionsCopie);
            breakie = false;
            a = 0;
            instructions.get(positionJumps.get(j)).operation = "nop";
            alreadyPerformedInstructions.clear();
            for (int i = 0; i < instructions.size(); ) {
                if (alreadyPerformedInstructions.contains(i)) {
                    breakie = true;
                    break;
                }

                if (instructions.get(i).operation.equals("acc")) {
                    a += instructions.get(i).value;
                    alreadyPerformedInstructions.add(i);
                    i++;
                    continue;
                }

                if (instructions.get(i).operation.equals("nop")) {
                    alreadyPerformedInstructions.add(i);
                    i++;
                    continue;
                }

                if (instructions.get(i).operation.equals("jmp")) {
                    alreadyPerformedInstructions.add(i);
                    i += instructions.get(i).value;
                    continue;
                }
                System.out.println(instructions.get(i).operation);
            }
            instructions.get(positionJumps.get(j)).operation = "jmp";

            if (!breakie) {
                System.out.println(a);
                b = a;
            }

        }
    }
}


class Instruction {
    String operation;
    int value;
    int instruction;

    Instruction(String op, int val, int inst) {
        this.operation = op;
        this.value = val;
        this.instruction = inst;
    }
}