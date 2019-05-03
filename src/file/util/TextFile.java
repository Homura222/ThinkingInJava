package file.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 文件操作工具类
 */
public class TextFile extends ArrayList<String> {
    //打开文件后记得关闭
    //文件读取
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            String s;
            try {
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    //文件写入
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile()
            );
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName, String splitter) {
        //通过换行符把结果按行划分
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) remove(0);
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }
    //写入文件
    public void write(String fileName){
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile()
            );
            try {
                for (String item : this)
                    out.println(item);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args){
        String file=read("TextFile.java");
        //编写文件1
        write("text.txt",file);
        TextFile text=new TextFile("text.txt");
        //编写文件2
        text.write("text2.txt");
        //分割符 匹配字母，数字，下划线
        TreeSet<String> words=new TreeSet<String>(new TextFile("TextFile.java","\\W+"));
        System.out.println(words.headSet("a"));
    }
}
