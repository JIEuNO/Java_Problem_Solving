import java.lang.Math;

class Solution {
    public static int len = 3001;
    public static boolean isPrime[] = new boolean[len];
    
    public int solution(int[] nums) {
        int answer = 0, numsLen = nums.length;
        
        checkPrime();
        
        for (int a = 0; a < numsLen; a++) {
            for (int b = a + 1; b < numsLen; b++) {
                for (int c = b + 1; c < numsLen; c++) {
                    if (isPrime[nums[a] + nums[b] + nums[c]])
                        answer += 1;
                }
            }
        }
        
        return answer;
    }
    
    public static void checkPrime() {
        for (int i = 0; i < len; i++)
            isPrime[i] = true;
        
        for (int i = 2; i <= Math.sqrt(len); i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j < len; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
    }
}