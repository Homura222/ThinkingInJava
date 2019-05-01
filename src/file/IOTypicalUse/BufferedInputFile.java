package file.IOTypicalUse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 缓冲输入文件
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        //fileReader打开，bufferedReader缓冲
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        //readLine不为null则继续
        while ((s = in.readLine()) != null)
            sb.append(s + "\n");
        //关闭reader
        in.close();
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        System.out.println(read("BufferedInputFile.java"));
    }
}
