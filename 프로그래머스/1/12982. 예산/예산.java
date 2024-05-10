import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0, sum = 0;
        
        Arrays.sort(d);
        
        for (int i = 0; i < d.length; i++) {
            if (sum + d[i] > budget)
                break;
            sum += d[i];
            answer += 1;
        }
        
        return answer;
    }
}