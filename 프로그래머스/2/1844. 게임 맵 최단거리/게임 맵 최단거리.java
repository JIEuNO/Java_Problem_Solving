class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length, m = maps[0].length, x, y;
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        Queue q = new Queue(n * m + 1);
        Location res;
        
        q.insert(new Location(0, 0, 1));
        maps[0][0] = 0;
        
        while(!q.isEmpty()) {
            res = q.pop();
            
            if (res.x == n - 1 && res.y == m - 1) {
                answer = res.cnt;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                x = res.x + dx[i];
                y = res.y + dy[i];
                if (!isValid(x, y, n, m))
                    continue;
                if (maps[x][y] == 1) {
                    q.insert(new Location(x, y, res.cnt + 1));
                    maps[x][y] = 0;
                }
            }       
        }
        
        if (answer == Integer.MAX_VALUE)
            return -1;
        
        return answer;
    }
    
    public boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}

class Location {
    int x, y, cnt;
    
    Location(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

class Queue {
    int front, rear;
    Location[] queue;
    
    Queue(int size) {
        this.queue = new Location[size];
        this.front = -1;
        this.rear = -1;
    }
    
    public void insert(Location data) {
        queue[++rear] = data;
    }
    
    public Location pop() {
        return queue[++front];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
}