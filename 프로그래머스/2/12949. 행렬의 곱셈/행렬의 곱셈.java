class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n1 = arr1.length, m1 = arr1[0].length;
        int n2 = arr2.length, m2 = arr2[0].length;
        int[][] answer = new int[n1][m2];
        
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                for (int u = 0; u < m2; u++) {
                    answer[i][u] += (arr1[i][j] * arr2[j][u]);
                }
            }
        }
        
        return answer;
    }
}