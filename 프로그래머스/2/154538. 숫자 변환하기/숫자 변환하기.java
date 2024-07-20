import java.lang.Math;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y)
            return 0;
        
        int idx;
        int[] num = new int[y + 1];
        
        for (int i = x + 1; i <= y; i++)
            num[i] = Integer.MAX_VALUE;
        num[x] = 0;
        
        for (int i = x; i < y; i++) {
            
            if (num[i] == Integer.MAX_VALUE)
                continue;
            
            idx = i + n;
            if (idx <= y)
                num[idx] = min(num[idx], num[i] + 1);
            
            idx = i << 1;
            if (idx <= y)
                num[idx] = min(num[idx], num[i] + 1);
            
            idx = i * 3;
            if (idx <= y)
                num[idx] = min(num[idx], num[i] + 1);
        }
        
        return num[y] == Integer.MAX_VALUE ? -1 : num[y];
    }
    
    public int min(int a, int b) {
        return a < b ? a : b;
    }
}