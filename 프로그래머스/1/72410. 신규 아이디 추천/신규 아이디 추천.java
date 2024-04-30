class Solution {
    public String solution(String new_id) {
        String answer = "";
        Character res;
        
        for (int i = 0; i < new_id.length(); i++) {
            res = new_id.charAt(i);
            
            // 2nd
            if (!isValidChar(res))
                continue;
            
            // 1st
            answer += Character.toLowerCase(res);
        }
        
        // 3rd
        while (answer.contains(".."))
            answer = answer.replace("..", ".");
         
        // 4st - 1
        if (answer.charAt(0) == '.')
            answer = answer.substring(1, answer.length());
        
        // 6th
        if (answer.length() >= 16) 
            answer = answer.substring(0, 15);
        
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.')
            answer = answer.substring(0, answer.length() - 1);
        
        // 7th
        if (answer.length() <= 2) {
            // 5th
            if (answer.length() == 0)
                answer = "a";
            
            res = answer.charAt(answer.length() - 1);
            while (answer.length() < 3)
                answer += res;
        }
        
        return answer.toString();
    }
    
    public boolean isValidChar(Character c) {
        return Character.isLetter(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.';
    }
}