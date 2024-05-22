class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        for (int i = 0; i < arr.length; i++) {
            answer = (answer * arr[i]) / gcd(answer, arr[i]);
        }
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        int tmp;
        if (a < b) {
            tmp = b;
            b = a;
            a = tmp;
        }
        
        while (b > 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        
        return a;
    }
    
}