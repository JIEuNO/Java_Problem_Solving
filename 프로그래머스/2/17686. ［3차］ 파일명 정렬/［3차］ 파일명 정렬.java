import java.util.Arrays;

class Solution {
    int len, idx, prev_idx, number;
    String file, head, tail;
    
    public String[] solution(String[] files) {
        int fileCnt = files.length;
        String[] answer = new String[fileCnt];
        File[] f = new File[fileCnt];
        
        for (int i = 0; i < fileCnt; i++) {
            file = files[i];
            len = file.length();
            init();
            
            while (idx < len && !Character.isDigit(file.charAt(idx))) {
                idx += 1;
            }
            head = file.substring(0, idx);
            
            prev_idx = idx;
            for (int j = idx; j < idx + 5; j++) {
                if (j >= len)
                    break;
                if (!Character.isDigit(file.charAt(j)))
                    break;
                idx += 1;
            }
            number = Integer.parseInt(file.substring(prev_idx, idx));
                
            if (idx < len)
                tail = file.substring(idx, len);
            else
                tail = "";
            
            f[i] = new File(i, head, number, tail);
        }
        
        
        Arrays.sort(f);
        for (int i = 0; i < fileCnt; i++)
            answer[i] = files[f[i].idx];
            
        return answer;
    }
    
    public void init() {
        head = "";
        number = 0;
        tail = "";
        idx = 0;
        prev_idx = 0;
    }
}

class File implements Comparable<File>{
    String head, tail;
    Integer idx, number;
    
    File (Integer idx, String head, Integer number, String tail) {
        this.idx = idx;
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
    
    @Override
    public int compareTo(File f) {
        int first = this.head.toLowerCase().compareTo(f.head.toLowerCase());
        if (first != 0)
            return first;
        
        return this.number.compareTo(f.number);
    }
}