class Solution {
    public static int w, h;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0, 0};
        w = park[0].length();
        h = park.length;
        int x = 0, y = 0, new_x = 0, new_y = 0, n;
        boolean isFinish = false, isValid = false;
        String op;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    isFinish = true;
                    break;
                }
            }
            if (isFinish)
                break;
        }
        
        for (int i = 0; i < routes.length; i++) {
            op = routes[i].split(" ")[0];
            n = Integer.parseInt(routes[i].split(" ")[1]);
            isValid = true;
            switch(op) {
                case "N":
                    new_x = x - n;
                    new_y = y;
                    isValid = check(park, x, new_x, new_y, true);
                    break;
                case "S":
                    new_x = x + n;
                    new_y = y;
                    isValid = check(park, x, new_x, new_y, true);
                    break;
                case "W":
                    new_x = x;
                    new_y = y - n;
                    isValid = check(park, y, new_y, new_x, false);
                    break;
                case "E":
                    new_x = x;
                    new_y = y + n;
                    isValid = check(park, y, new_y, new_x, false);
                    break;
            }
            if (isValid) {
                    x = new_x;
                    y = new_y;
            }
        }
        
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
    
    public static boolean check(String[] park, int start, int end, int n, boolean isX) {
        int s = (start < end)?start:end;
        int e = (start < end)?end:start;
        
        if (s < 0) return false;
        
        if (isX) {
            if (e >= h) return false;
            for (int i = s; i <= e; i++) 
                if (park[i].charAt(n) == 'X') 
                    return false;
            return true;
        }
        else {
            if (e >= w) return false;
            for (int i = s; i <= e; i++)
                if (park[n].charAt(i) == 'X')
                    return false;
            return true;
        }
    }
}