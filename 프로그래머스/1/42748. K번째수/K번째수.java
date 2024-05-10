import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length, i, j, k;
        int[] answer = new int[len], tmp;
        
        for (int u = 0; u < len; u++) {
            i = commands[u][0];
            j = commands[u][1];
            k = commands[u][2];
            
            tmp = IntStream.range(i - 1, j).map(t -> array[t]).toArray();
            Arrays.sort(tmp);
            
            answer[u] = tmp[k - 1];
        }
        
        return answer;
    }
}