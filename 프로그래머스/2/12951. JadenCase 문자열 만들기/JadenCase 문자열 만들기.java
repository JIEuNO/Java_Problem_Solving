import java.lang.StringBuilder;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isNew = true;
        char c;
 
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ') {
                answer.append(c);
                isNew = true;
                continue;
            }
            if (Character.isDigit(c)) 
                answer.append(c);
            else if (isNew) 
                answer.append(Character.toUpperCase(c));
            else
                answer.append(Character.toLowerCase(c));
            isNew = false;
        }
        
        return answer.toString();
    }
}