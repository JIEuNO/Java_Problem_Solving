import java.lang.Math;

class Solution {
    public boolean[] isDivided;
    
    public int solution(int n) {
        int answer = 0;
        isDivided = new boolean[n + 1];
        
        checkPrime(n);
        
        for (int i = 2; i <= n; i++)
            if (!isDivided[i])
                answer += 1;
                
        return answer;
    }
    
    public void checkPrime(int n) {
        int idx;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!isDivided[i]) {
                idx = 2;
                while (i * idx <= n) {
                    isDivided[i * idx] = true;
                    idx += 1;
                }
            }
        }
    }
}