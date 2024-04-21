class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int cur = 0, next = 1, gap;
            
        while (next < section.length) {
            gap = section[next] - section[cur] + 1;
            if (gap > m) {
                cur = next;
                next += 1;
                answer += 1;
            }
            else
                next += 1;
        }
        
        return answer;
    }
}