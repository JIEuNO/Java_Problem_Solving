class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder s = new StringBuilder();
        String str;
        int len = 0, num = 0, total = p + m * (t - 1);
        
        while (len < total) {
            str = convert(num, n);
            s.append(str);
            len += str.length();
            num += 1;
        }
        
        for (int i = p - 1; i < total; i += m)
            answer.append(s.charAt(i));
        
        return answer.toString();
    }
    
    public String convert(int num, int n) {
        StringBuilder str = new StringBuilder();
        int left;
        
        while (num >= n) {
            left = num % n;
            if (left < 10)
                str.append(ascii(left));
            else
                str.append(ascii(left));
            num /= n;
        }
        str.append(ascii(num));
        
        return str.reverse().toString();
    }
    
    public char ascii(int num) {
        return num < 10 ? (char) (num + '0') : (char) (num + 55);
    }
}