class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int idx = 0;
        
        answer[idx] = x;
        while (idx < n - 1) {
            idx += 1;
            answer[idx] = answer[idx - 1] + x;
        }
        
        return answer;
    }
}