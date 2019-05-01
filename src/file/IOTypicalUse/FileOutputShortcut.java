package file.IOTypicalUse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * 文本文件输出的快捷方式
 */
public class FileOutputShortcut {
    static String file="FileOutputShortcut.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("FileOutputShortcut.java")
                )
        );
        //shortcut
        //不必自己实现的缓存
        PrintWriter out=new PrintWriter(file);
        int lineCount=1;
        String s;
        while((s=in.readLine())!=null)
            out.println(lineCount++ +":"+s);
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
