class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int n, m;
 
        for (int i = 1; i <= yellow; i++) {
            n = i;
            m = (brown - 4) / 2 - i;
            if (n * m == yellow) {
                if (n > m) {
                    answer[0] = n + 2;
                    answer[1] = m + 2;
                }
                else {
                    answer[0] = m + 2;
                    answer[1] = n + 2;
                }
                break;
            }
            
        }
        
        return answer;
    }
}