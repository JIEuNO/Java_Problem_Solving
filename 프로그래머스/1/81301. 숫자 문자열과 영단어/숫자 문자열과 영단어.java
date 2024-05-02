import java.util.HashMap;

class Solution {
    
    public static HashMap<String, Integer> num = new HashMap<>();
    
    public int solution(String s) {
        int answer = 0, idx = 0, len = s.length();
        Character c;
        StringBuilder sb = new StringBuilder(), word;

        init();
        
        while (idx < len) {
            c = s.charAt(idx);
            if (Character.isDigit(c)) {
                sb.append(c);
                idx += 1;
            }
            else {
                word = new StringBuilder();
                while (idx < len && !Character.isDigit(s.charAt(idx))) {
                    word.append(s.charAt(idx));
                    idx += 1;
                    if (num.containsKey(word.toString())) {
                        sb.append(num.get(word.toString()));
                        break;
                    }
                }
            }
                
        }
        
        answer = Integer.parseInt(sb.toString());
        
        return answer;
    }
    
    public static void init() {
        num.put("zero", 0);
        num.put("one", 1);
        num.put("two", 2);
        num.put("three", 3);
        num.put("four", 4);
        num.put("five", 5);
        num.put("six", 6);
        num.put("seven", 7);
        num.put("eight", 8);
        num.put("nine", 9);
    }
}