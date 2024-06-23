class Solution {
    public int solution(int[] citations) {
        int answer = 0, n = citations.length, cnt;
        
        for (int i = n; i >= 0; i--) {
            cnt = 0;
            for (int j = 0; j < n; j++) {
                if (citations[j] >= i)
                    cnt += 1;
            }
            if (cnt >= i) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}