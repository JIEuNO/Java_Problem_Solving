class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str;
        String[] arr;
        
        str = convert(n, k);
        arr = str.split("0");
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isEmpty())
                continue;
            if (isPrime(Long.parseLong(arr[i])))
                answer += 1;
        }
        
        return answer;
    }
    
    public String convert(int n, int k) {
        StringBuilder res = new StringBuilder();
        
        while (n >= k) {
            res.append(Integer.toString(n % k));
            n /= k;
        }
        res.append(n);
        
        return res.reverse().toString();
    }
    
    public boolean isPrime(long n) {
        if (n < 2) return false;
        
        for (int i = 2; i <= (int) Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        
        return true;
    }
}