package ProgrammingPearls.Chapter3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * 根据用户记录将对应的信息填入信函模板中的占位符，从而生成定制的信函
 */
public class LetterGenerator {
    private String schema;

    public LetterGenerator(String filename) throws IOException{
        Path path = Paths.get(filename);
        schema = Files.readString(path);
    }

    public String generateBy(UserInfo info){
        String letter = schema.replace("$0", info.getUsername())
                      .replace("$1", info.getEmail())
                      .replace("$2", String.format("%02d",info.getMonth()))
                      .replace("$3", String.format("%02d",info.getDay()));
        return letter;
    }
}

class UserInfo{
    private String username;
    private String email;
    private int month, day;

    public UserInfo(String username, String email, int month, int day){
        this.username = username;
        this.email = email;
        this.month = month;
        this.day = day;
    }

    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
}
