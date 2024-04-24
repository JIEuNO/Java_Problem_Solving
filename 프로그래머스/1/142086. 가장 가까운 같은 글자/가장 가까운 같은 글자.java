import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int len = s.length();
        char input;
        HashMap<Character, Node> map = new HashMap<>();
        Node node, lastNode;
        
        for (int i = len - 1; i >= 0; i--) {
            input = s.charAt(i);
            if (map.containsKey(input)) {
                lastNode = map.get(input);
                while (lastNode.next != null)
                    lastNode = lastNode.next;
                lastNode.next = new Node(i);
            }
            else {
                map.put(input, new Node(i));
            }
        }
        
        for (int i = 0; i < len; i++) {
            input = s.charAt(i);
            node = map.get(input);
            while(true) {
                if (node.next == null) {
                    answer[i] = -1;
                    break;
                }
                if (node.idx == i) {
                    answer[i] = node.idx - node.next.idx;
                    break;
                }
                node = node.next;
            }
        }
        
        return answer;
    }
}
class Node {
    int idx;
    Node next;
    
    Node(int idx) {
        this.idx = idx;
        this.next = null;
    }
    
    Node(int idx, Node next) {
        this.idx = idx;
        this.next = next;
    }
}