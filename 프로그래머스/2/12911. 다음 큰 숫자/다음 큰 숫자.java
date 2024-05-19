class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int nCount = countOne(n);
        
        while (nCount != countOne(answer)) {
            answer += 1;
        }
        
        return answer;
    }
    
    public int countOne(int num) {
        int count = 0;
        
        while (num > 0) {
            if ((num & 1) == 1)
                count += 1;
            num >>= 1;
        }
        
        return count;
    }
}