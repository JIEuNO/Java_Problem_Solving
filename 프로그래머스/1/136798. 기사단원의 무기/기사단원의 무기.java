import java.lang.Math;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int factor;
        
        for (int i = 1; i <= number; i++) {
            factor = countFactor(i);
            if (factor > limit)
                answer += power;
            else
                answer += factor;
            
        }
        
        return answer;
    }
    
    public int countFactor(int n) {
        int count = 0;
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count += 1;
                if (i != (n / i))
                    count += 1;
            }
        }
        
        return count;
    }
}