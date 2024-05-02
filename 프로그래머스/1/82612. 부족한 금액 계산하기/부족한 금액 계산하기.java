import java.lang.Math;

class Solution {
    public long solution(int price, int money, int count) {
        // sum = n * (2 * a + (n - 1) * d) / 2
        long total = ((long)count * (long)price * (long)(count + 1)) >> 1;
        long answer = money >= total ? 0 : total - money;
        
        return answer;
    }
}