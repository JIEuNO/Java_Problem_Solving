class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int val;
        
        for (int i = 0; i < n; i++) {
            answer[i] = "";
            val = arr1[i] | arr2[i];
            for (int j = n - 1; j >= 0; j--) {
                if ((val & (1 << j)) != 0)
                    answer[i] += "#";
                else
                    answer[i] += " ";
            }
        }
        
        return answer;
    }
}