class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length, idx, cnt;
        String bin;
        long[] answer = new long[len];
        
        for (int i = 0; i < len; i++) {
            bin = Long.toBinaryString(numbers[i]);
            idx = bin.length() - 1;
            cnt = 0;
            while (idx >= 0) {
                if (bin.charAt(idx) == '0')
                    break;
                idx -= 1;
                cnt += 1;
            }
            
            answer[i] = numbers[i] + findNext(cnt - 1);
        }
        
        return answer;
    }
    
    public long findNext(int n) {
        long res = 1;
        
        for (int i = 0; i < n; i++)
            res <<= 1;
        
        return res;
    }
}