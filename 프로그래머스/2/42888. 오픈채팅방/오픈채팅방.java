import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        int len = record.length;
        char c;
        String[] str, answer;
        List<Command> command = new ArrayList<>();
        Map<String, User> name = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            str = record[i].split(" ");
            c = str[0].charAt(0);
            if (c == 'E') {
                if (!name.containsKey(str[1]))
                    name.put(str[1], new User(str[1], str[2]));
                else
                    name.get(str[1]).nickname = str[2];
                command.add(new Command(c, str[1]));
            }
            else if (c == 'L') {
                command.add(new Command(c, str[1]));
            }
            else if (c == 'C') {
                name.get(str[1]).nickname = str[2];
            }
        }
        
        answer = new String[command.size()];
        for (int i = 0; i < command.size(); i++) {
            String s;
            if (command.get(i).c == 'E')
                s = "님이 들어왔습니다.";
            else
                s = "님이 나갔습니다.";
            answer[i] = name.get(command.get(i).uid).nickname + s;
        }  
        
        return answer;
    }
}

class User {
    
    String uid, nickname;
    
    User (String uid, String nickname) {
        this.uid = uid;
        this.nickname = nickname;
    }
}

class Command {
    
    char c;
    String uid;
    
    Command (char c, String uid) {
        this.c = c;
        this.uid = uid;
    }
    
}