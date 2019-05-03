package file.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {
    //回显输入
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String s;
        //输入为空则退出
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            System.out.println(s);
            System.err.println(s);
        }
    }
}
