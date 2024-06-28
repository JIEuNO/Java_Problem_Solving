import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        int len = phone_book.length;
        String str;
        
        Arrays.sort(phone_book);
        
        for (int i = 0; i < len - 1; i++) {
            str = phone_book[i];
            for (int j = i + 1; j < len; j++) {
                if (str.length() <= phone_book[j].length()
                    && str.equals(phone_book[j].substring(0, str.length())))
                    return false;
                else
                    break;
            }
        }
        
        return true;
    }
}