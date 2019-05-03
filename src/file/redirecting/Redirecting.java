package file.redirecting;

import java.io.*;

/**
 * 文件流重定向
 * 控制的是流而不是字符
 * 故使用InputStream和OutputStream
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console=System.out;
        BufferedInputStream in=new BufferedInputStream(
                new FileInputStream("Redirecting.java")
        );
        PrintStream out=new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("test.out")
                )
        );
        //输入流设定为文件
        System.setIn(in);
        //输出流设定为test.out
        System.setOut(out);
        //错误流设定为test.out
        System.setErr(out);
        BufferedReader br=new BufferedReader(
                new InputStreamReader(System.in)
        );
        String s;
        //全部输出到文件中
        while ((s=br.readLine())!=null){
            System.out.println(s);
        }
        out.close();
        //恢复输出流的地址,即恢复为控制台
        System.setOut(console);
    }
}
