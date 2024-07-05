import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String word) {
        int answer = 0, len = word.length();
        int[] w = new int[5];
        Map<Character, Integer> alpha = new HashMap<>();
        
        w[4] = 1;
        for (int i = 3; i >= 0; i--)
            w[i] = w[i + 1] * 5 + 1;
        
        alpha.put('A', 0);
        alpha.put('E', 1);
        alpha.put('I', 2);
        alpha.put('O', 3);
        alpha.put('U', 4);
        
        for (int i = 0; i < len; i++)
            answer += (w[i] * alpha.get(word.charAt(i)) + 1);
        
        return answer;
    }
}