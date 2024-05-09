import java.lang.StringBuilder;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer.append(s.charAt(i));
                idx = 0;
                continue;
            }
            if (idx % 2 == 0)
                answer.append(Character.toUpperCase(s.charAt(i)));
            else
                answer.append(Character.toLowerCase(s.charAt(i)));
            idx += 1;
        }
        
        return answer.toString();
    }
}