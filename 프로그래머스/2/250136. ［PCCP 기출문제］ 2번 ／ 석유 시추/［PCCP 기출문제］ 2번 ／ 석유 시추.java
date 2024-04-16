import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] land) {
        int n = land.length, m = land[0].length, sum, index = 1, max = 0;
        int[][] idx = new int[n][m];
        int[] size = new int[n * m];
        boolean[][] visited = new boolean[n][m];
        boolean[] isCheck = new boolean[n * m];
        Loc[] move = {new Loc(-1, 0), new Loc(1, 0), new Loc(0, -1), new Loc(0, 1)};
        Loc res, new_res = new Loc();
        Queue<Loc> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || land[i][j] == 0) continue;
                queue.add(new Loc(i, j));
                visited[i][j] = true;
                idx[i][j] = index;
                sum = 0;
                while (!queue.isEmpty()) {
                    res = queue.poll();
                    sum += 1;
                    for (int k = 0; k < move.length; k++) {
                        new_res.x = res.x + move[k].x;
                        new_res.y = res.y + move[k].y;
                        if (0 <= new_res.x && new_res.x < n && 0 <= new_res.y && new_res.y < m) {
                            if (land[new_res.x][new_res.y] == 1 && !visited[new_res.x][new_res.y]) {
                                queue.add(new Loc(new_res.x, new_res.y));
                                visited[new_res.x][new_res.y] = true;
                                idx[new_res.x][new_res.y] = index;
                            }
                        }
                    }
                }   
                size[index] = sum;
                index += 1;
            }
        }
 
        for (int i = 0; i < m; i++) {
            sum = 0;
            for (int j = 0; j < index; j++)
                isCheck[j] = false;
            for (int j = 0; j < n; j++) {
                if (!isCheck[idx[j][i]]) {
                    sum += size[idx[j][i]];
                    isCheck[idx[j][i]] = true;
                }
            }
            max = (sum > max)? sum : max;
        }
        
        return max;
    }
}
class Loc {
    int x, y;
    Loc() {}
    Loc(int x, int y) {
        this.x = x;
        this.y = y;
    }
}