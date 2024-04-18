import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] maps) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int n = maps.length, m = maps[0].length();
        int sum, new_x, new_y;
        boolean[][] isVisited = new boolean[n][m];
        Loc[] d = {new Loc(-1, 0), new Loc(1, 0), new Loc(0, -1), new Loc (0, 1)};
        Queue<Loc> queue = new LinkedList<Loc>();
        Loc res;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X' && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    sum = maps[i].charAt(j) - '0';
                    queue.offer(new Loc(i, j));
                    while (!queue.isEmpty()) {
                        res = queue.poll();
                        for (int k = 0; k < d.length; k++) {
                            new_x = res.x + d[k].x;
                            new_y = res.y + d[k].y;
                            if (0 <= new_x && new_x < n && 0 <= new_y && new_y < m) {
                                if (maps[new_x].charAt(new_y) != 'X' && !isVisited[new_x][new_y]) {
                                    isVisited[new_x][new_y] = true;
                                    sum += maps[new_x].charAt(new_y) - '0';
                                    queue.offer(new Loc(new_x, new_y));
                                }
                            }
                        }
                    }
                    arr.add(sum);
                }
            }
        }
        
        if (arr.size() == 0)
            return new int[] {-1};
        
        Collections.sort(arr);
        
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
    
    class Loc {
        int x, y;
        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}