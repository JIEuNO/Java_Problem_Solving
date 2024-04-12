class Solution {
    static int[] answer = new int[2];
    static int min = Integer.MAX_VALUE;

    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int s = 0, e = 1;
        int sum = sequence[s] + sequence[e];
        
        if (sequence[s] == k) {
            answer[0] = s;
            answer[1] = s;
            return answer;
        }
        
        while (s <= e && e < n) {
            if (sum == k) {
                if (e - s + 1 < min) {
                    min = e - s + 1;
                    answer[0] = s;
                    answer[1] = e;
                }
                sum -= sequence[s];
                s += 1;
                e += 1;
                if (e < n)
                    sum += sequence[e];
            }
            else if (sum > k) {
                sum -= sequence[s];
                s += 1;
            }
            else {
                e += 1;
                if (e < n)
                    sum += sequence[e];
            }
        }
        
        return answer;
    }
}