import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int len = score.length, box = len / m;
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < len; i++)
            arr.add(score[i]);
        Collections.sort(arr, Collections.reverseOrder());
        
        for (int i = m - 1; i < box * m; i += m)
            answer += arr.get(i);
        answer *= m;
 
        return answer;
    }
}