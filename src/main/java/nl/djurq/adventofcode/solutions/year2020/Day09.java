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

        List<Long> continuesNumbers = new ArrayList<>();
        FoundWeaknes:for (int i = 0; i < input.size(); i++) {
            long num1 = Long.parseLong(input.get(i));
            long sum = num1;
            continuesNumbers.add(num1);

            for (int i1 = i+1; i1 < input.size(); i1++) {
                long num2 = Long.parseLong(input.get(i1));
                sum += num2;
                continuesNumbers.add(num2);
                if (sum > a){
                    break;
                }
                if (sum == a){
                    long maxValue = continuesNumbers.get(0);
                    for (int j = 1; j < continuesNumbers.size(); j++) {
                        if (continuesNumbers.get(j) > maxValue) {
                            maxValue = continuesNumbers.get(j);
                        }
                    }

                    long minValue = continuesNumbers.get(0);
                    for (int k = 1; k < continuesNumbers.size(); k++) {
                        if (continuesNumbers.get(k) < minValue) {
                            minValue = continuesNumbers.get(k);
                        }
                    }
                    b = maxValue + minValue;
                    break FoundWeaknes;
                }
            }
            for (Long continuesNumber : continuesNumbers) {
                System.out.println(continuesNumber);
            }
            System.out.println();
            continuesNumbers.clear();
        }
        
    }
}
