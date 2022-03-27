package programers.level1.pressKeyPad;

import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Integer> useLeftHand = new ArrayList<>(Arrays.asList(1, 4, 7));
        ArrayList<Integer> useRightHand = new ArrayList<>(Arrays.asList(3, 6, 9));

        int leftHand = 10;
        int rightHand = 12;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) numbers[i] = 11;

            if (useLeftHand.contains(numbers[i])) {
                leftHand = numbers[i];
                answer.append("L");
            }
            else if (useRightHand.contains(numbers[i])) {
                rightHand = numbers[i];
                answer.append("R");
            } else {
                int disLeft = distance(numbers[i], leftHand);
                int disRight = distance(numbers[i], rightHand);

                if (disLeft > disRight) {
                    rightHand = numbers[i];
                    answer.append("R");
                } else if (disLeft < disRight) {
                    leftHand = numbers[i];
                    answer.append("L");
                } else {
                    if (hand.equals("right")) {
                        rightHand = numbers[i];
                        answer.append("R");
                    } else {
                        leftHand = numbers[i];
                        answer.append("L");
                    }
                }
            }
        }
        return answer.toString();
    }

    public int distance(int number, int hand) {
        int diff = Math.abs(number - hand);
        return diff / 3 + diff % 3;
    }
}