package file.IOTypicalUse;

import java.io.*;

/**
 * 基本的文件输出
 */
public class BasicFileOutput {
    static String file="BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        //缓冲区读取
        BufferedReader in=new BufferedReader(new StringReader(BufferedInputFile.read("BasicFileOutput.java")));
        //缓冲输出（缓冲往往能显著地增加I/O操作的性能）
        PrintWriter out=new PrintWriter(
                new BufferedWriter(new FileWriter(file))
        );
        int lineCount=1;
        String s;
        //打印
        while ((s=in.readLine())!=null){
            out.println(lineCount++ + ":"+s);
        }
        //关闭输出流
        out.close();
        //读取已输出的文件信息
        System.out.println(BufferedInputFile.read(file));
    }
}
