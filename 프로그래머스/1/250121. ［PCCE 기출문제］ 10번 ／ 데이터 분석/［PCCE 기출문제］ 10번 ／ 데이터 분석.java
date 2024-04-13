import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> compare = new ArrayList<int[]>();
        Map<String, Integer> idx = Map.of("code", 0, "date", 1, "maximum", 2, "remain", 3);
        int ext_idx = idx.get(ext);
        int sort_idx = idx.get(sort_by);
        
        for (int i = 0; i < data.length; i++)
            if (data[i][ext_idx] < val_ext)
                compare.add(data[i]);
        
        Collections.sort(compare, (s1, s2) -> s1[sort_idx] - s2[sort_idx]);
            
        int[][] answer = new int[compare.size()][data[0].length];
        for (int i = 0; i < compare.size(); i++) {
            answer[i] = compare.get(i);
        }

        return answer;
    }
}