import java.util.HashMap;

class Solution {
    public static HashMap<Integer, Integer> day = new HashMap<>();
    public static String[] days = new String[] {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    
    public String solution(int a, int b) {
        String answer = "";
        int sum = 0, idx = 5;
        setDay();
 
        for (int i = 1; i < a; i++) {
            sum += day.get(i);
        }
        sum += (b - 1);
        
        idx = (idx + (sum % 7)) % days.length;
        
        return days[idx];
    }
    
    public static void setDay() {
        day.put(1, 31);
        day.put(2, 29);
        day.put(3, 31);
        day.put(4, 30);
        day.put(5, 31);
        day.put(6, 30);
        day.put(7, 31);
        day.put(8, 31);
        day.put(9, 30);
        day.put(10, 31);
        day.put(11, 30);
        day.put(12, 31);
    }
}