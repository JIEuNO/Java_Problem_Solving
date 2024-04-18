class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int t_len = t.length(), p_len = p.length();
        
        for (int i = 0; i < t_len - p_len + 1; i++) 
            if (t.substring(i, i + p_len).compareTo(p) <= 0)
                answer += 1;
        
        return answer;
    }
}