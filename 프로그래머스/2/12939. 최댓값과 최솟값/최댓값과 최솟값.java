class Solution {
    public String solution(String s) {
        String answer;
        String[] num = s.split(" ");
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, tmp;
        
        for (int i = 0; i < num.length; i++) {
            tmp = Integer.parseInt(num[i]);
            min = (tmp < min) ? tmp : min;
            max = (tmp > max) ? tmp : max;
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}