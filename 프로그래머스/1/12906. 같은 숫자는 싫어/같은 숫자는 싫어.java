import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int idx = 0, len = arr.length;
        
        while (idx < len) {
            answer.add(arr[idx]);
            while (idx + 1 < len && arr[idx] == arr[idx + 1])
                idx += 1;
            idx += 1;
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}