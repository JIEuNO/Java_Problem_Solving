class Solution {
    public int solution(int n) {
        int answer = 0, sum;
        
        for (int i = 1; i <= n; i++) {
            sum = i;
            for (int j = i + 1; sum < n; j++)
                sum += j;
            if (sum == n)
                answer += 1;
        }
        
        return answer;
    }
}