import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {
        double answer = 0;
        int inter = 0, union = 0;
        Node n1, n2;
        List<Node> arr1, arr2;
        
        arr1 = addStr(str1);
        arr2 = addStr(str2);
        
        for (int i = 0; i < arr1.size(); i++) {
            n1 = arr1.get(i);
            for (int j = 0; j < arr2.size(); j++) {
                n2 = arr2.get(j);
                if (n2.isVisited)
                    continue;
                if (n1.str.equals(n2.str)) {
                    inter += 1;
                    n2.isVisited = true;
                    break;
                }
            }
        }
        
        union = arr1.size() + arr2.size() - inter;
        
        if (arr1.size() == 0 && arr2.size() == 0)
            answer = 1;
        else
            answer = (double) inter / union;
        
        return (int) Math.floor(answer * 65536);
    }
    
    public List<Node> addStr(String str) {
        String s;
        boolean isValid;
        List<Node> arr = new ArrayList<>();
        
        for (int i = 0; i < str.length() - 1; i++) {
            s = str.substring(i, i + 2).toLowerCase();
            isValid = true;
            for (int j = 0; j < 2; j++) {
                if (!Character.isLetter(s.charAt(j))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid)
                arr.add(new Node(s));
        }
    
        return arr;
    }
}

class Node {
    String str;
    boolean isVisited;
    
    Node(String str) {
        this.str = str;
        this.isVisited = false;
    }
}