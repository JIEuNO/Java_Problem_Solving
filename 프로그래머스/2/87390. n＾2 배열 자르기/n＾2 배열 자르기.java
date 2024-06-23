class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        int idx = 0, r, c;
        
        for (long i = left; i <= right; i++) {
            r = (int) (i / n);
            c = (int) (i % n);
            answer[idx++] = (r > c) ? r + 1 : c + 1;
        }
        
        return answer;
    }
}