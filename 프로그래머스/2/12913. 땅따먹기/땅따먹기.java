class Solution {
    int solution(int[][] land) {
        int answer = 0, n = land.length, m = 4;
        int[][] dp = new int[n + 1][m];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = cal_prev(i, j, m, dp) + land[i - 1][j];
            }
        }
        
        for (int i = 0; i < m; i++)
            answer = dp[n][i] > answer ? dp[n][i] : answer;
        
        return answer;
    }
    
    public int cal_prev(int row, int col, int m, int[][] dp) {
        int max = 0;
        
        for (int i = 0; i < m; i++) {
            if (i == col)
                continue;
            max = dp[row - 1][i] > max ? dp[row - 1][i] : max;
        }
        
        return max;
    }
}