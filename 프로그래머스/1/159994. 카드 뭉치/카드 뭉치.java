import java.util.HashMap;

class Solution {
    
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int idx1 = 0, idx2 = 0;
        int len1 = cards1.length, len2 = cards2.length;
        
        for (int i = 0; i < goal.length; i++) {
            if (idx1 < len1 && goal[i].equals(cards1[idx1]))
                idx1 += 1;
            else if (idx2 < len2 && goal[i].equals(cards2[idx2]))
                idx2 += 1;
            else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}