class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0, len = absolutes.length, val;
        
        for (int i = 0; i < len; i++) 
            answer += signs[i] ? absolutes[i] : -absolutes[i];

        return answer;
    }
}