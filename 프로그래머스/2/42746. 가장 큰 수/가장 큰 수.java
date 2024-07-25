import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        int len = numbers.length;
        String answer = "";
        String[] str = new String[len];
        
        for (int i = 0; i < len; i++)
            str[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.repeat(4).compareTo(o1.repeat(4));
            }
        });
        
        if (str[0].equals("0"))
            return "0";
        
        for (int i = 0; i < len; i++)
            answer += str[i];
        
        return answer;
    }
}