import java.lang.Math;
import java.lang.StringBuilder;

class Solution {
    public static int col = 3;
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] idx = {-1, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2};
        int left = 10, right = 12, val, leftVal, rightVal;
        
        for (int i = 0; i < numbers.length; i++) {
            if (idx[numbers[i]] == 0) {
                answer.append("L");
                left = numbers[i];
            }
            else if (idx[numbers[i]] == 2) {
                answer.append("R");
                right = numbers[i];
            }
            else {
                val = (numbers[i] == 0) ? 11 : numbers[i];
                leftVal = distance(left, val);
                rightVal = distance(right, val);
                if (leftVal == rightVal) {
                    if (hand.equals("left")) {
                        answer.append("L");
                        left = val;
                    }
                    else {
                        answer.append("R");
                        right = val;
                    }
                }
                else if (leftVal < rightVal) {
                    answer.append("L");
                    left = val;
                }
                else {
                    answer.append("R");
                    right = val;
                }
            }
                
        }
        
        return answer.toString();
    }
    
    public static int distance(int a, int b) {
        int aY = (a - 1) / col, aX = (a - 1) % col;
        int bY = (b - 1) / col, bX = (b - 1) % col;
        
        return Math.abs(aY - bY) + Math.abs(aX - bX);   
    }
}