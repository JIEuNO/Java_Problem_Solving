import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> rec = new HashSet<String>();
        char prev = words[0].charAt(0);
        
        for (int i = 0; i < words.length; i++) {
            if (rec.contains(words[i]) | prev != words[i].charAt(0)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            prev = words[i].charAt(words[i].length() - 1);
            rec.add(words[i]);
        }
        
        return answer;
    }
}