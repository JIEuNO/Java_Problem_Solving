import java.util.Map;

class Solution {
    public int solution(String dirs) {
        int answer = 0, len = dirs.length();
        int x = 0, y = 0, new_x, new_y, n = 5, m = 5, index;
        char c;
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        boolean[][] isVisitedV = new boolean[n << 1 + 1][m << 1 + 1], isVisitedH = new boolean[n << 1 + 1][m << 1 + 1];
        Map<Character, Integer> idx = Map.of('U', 0, 'D', 1, 'R', 2, 'L', 3);
        
        for (int i = 0; i < len; i++) {
            index = idx.get(dirs.charAt(i));
            new_x = x + dx[index];
            new_y = y + dy[index];
            if (new_x < -n || new_x > n || new_y < -m || new_y > m) {
                continue;
            }
            
            switch(index) {
                case 0:
                    if (!isVisitedH[new_x + n][new_y + n]) {
                        isVisitedH[new_x + n][new_y + n] = true;
                        answer += 1;
                    }
                    break;
                case 1:
                    if (!isVisitedH[x + n][y + n]) {
                        isVisitedH[x + n][y + n] = true;
                        answer += 1;
                    }
                    break;
                case 2:
                    if (!isVisitedV[new_x + n][new_y + n]) {
                        isVisitedV[new_x + n][new_y + n] = true;
                        answer += 1;
                    }
                    break;
                case 3:
                    if (!isVisitedV[x + n][y + n]) {
                        isVisitedV[x + n][y + n] = true;
                        answer += 1;
                    }
                    break;
            }
            x = new_x;
            y = new_y;
        }
        
        return answer;
    }
}