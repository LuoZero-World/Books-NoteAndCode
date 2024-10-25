package ProgrammingPearls.Chapter3;

import java.io.IOException;

public class Chapter3 {
    public static void main(String[] args) {
        try {
            LetterGenerator lg = new LetterGenerator("ProgrammingPearls\\Chapter3\\template.txt");
            UserInfo info = new UserInfo("JackLi", "1234567@qq.com", 5, 12);
            System.out.println(lg.generateBy(info));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
