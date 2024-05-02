class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_w = 0, max_h = 0;
        int s, b;
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                s = sizes[i][0];
                b = sizes[i][1];
            }
            else {
                s = sizes[i][1];
                b = sizes[i][0];
            }
            max_w = s > max_w ? s : max_w;
            max_h = b > max_h ? b : max_h;          
        }
        
        answer = max_w * max_h;
        
        return answer;
    }
}