import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        boolean isFind = false;
        ArrayList<String> tb = new ArrayList<>();
        Arrays.sort(book_time, 
            new Comparator<String[]>() {
                @Override
                public int compare(String[] s1, String[] s2) {
                    return s1[0].compareTo(s2[0]);
                }
            }
        );
        
        for (int i = 0; i < book_time.length; i++) {
            isFind = false;
            for (int j = 0; j < tb.size(); j++) {
                if (book_time[i][0].compareTo(tb.get(j)) >= 0) {
                    isFind = true;
                    tb.set(j, cleanUp(book_time[i][1]));
                    break;
                }
            }
            if (!isFind) {
                answer += 1;
                tb.add(cleanUp(book_time[i][1]));
            }
        }
        
        return answer;
    }
    
    public static String cleanUp(String endTime) {
        int hour = Integer.parseInt(endTime.substring(0, 2));
        int minute = Integer.parseInt(endTime.substring(3, 5));
        if (minute + 10 >= 60) {
            hour += 1;
            minute = (minute + 10) % 60;
        }
        else {
            minute += 10;
        }
        return String.format("%02d:%02d", hour, minute);
    }
}