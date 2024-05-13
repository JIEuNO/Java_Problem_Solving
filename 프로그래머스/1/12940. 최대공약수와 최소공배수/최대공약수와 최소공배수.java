class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        answer[0] = gcd(n, m);
        answer[1] = n * m / answer[0];
        
        return answer;
    }
    
    public int gcd(int n, int m) {
        int tmp;
        
        if (n < m) { // n >= m
            tmp = n;
            n = m;
            m = tmp;
        }
        
        while (m != 0) {
            tmp = n % m;
            n = m;
            m = tmp;
        }
        
        return n;
    }
}