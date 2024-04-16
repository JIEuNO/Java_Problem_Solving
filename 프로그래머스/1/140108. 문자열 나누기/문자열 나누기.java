class Solution {
    public int solution(String s) {
        int answer = 1, s_cnt = 1, d_cnt = 0;
        char first = s.charAt(0);
        
        for (int i = 1; i < s.length(); i++) {
            if (s_cnt == d_cnt) {
                first = s.charAt(i);
                s_cnt = 0;
                d_cnt = 0;
                answer += 1;
            }
            if (s.charAt(i) == first) s_cnt += 1;
            else d_cnt += 1;
        }
        return answer;
    }
}