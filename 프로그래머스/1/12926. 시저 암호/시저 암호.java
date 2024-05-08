import java.lang.StringBuilder;

class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        Character c, input;
        
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ') 
                input = ' ';
            else if (Character.isLowerCase(c))
                input = c + n > 122 ? (char)(97 + (c + n) % 123) : (char)(c + n);
            else
                input = c + n > 90 ? (char)(65 + (c + n) % 91) : (char)(c + n);
            answer.append(input);
        }
        
        return answer.toString();
    }
}