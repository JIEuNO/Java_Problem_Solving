class Solution {
    public int solution(int[] number) {
        int answer = 0, len = number.length;
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int u = j + 1; u < len; u++) {
                    if (i == j || j == u || u == i)
                        continue;
                    if (number[i] + number[j] + number[u] == 0)
                        answer += 1;
                }
            }
        }
        return answer;
    }
}