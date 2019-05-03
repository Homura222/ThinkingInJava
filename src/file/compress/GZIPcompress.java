package file.compress;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 直接将输出流封装成GZIPOutputStream或ZIPOutputStream
 * 并将输入流封装成GZIPInputStream或ZipInputStream即可
 * 其他的都是通常的I/O读写
 */
public class GZIPcompress {
    public static void main(String[] args) throws IOException {
        if (args.length==0){
            System.out.println(
                    "Usage: \n GZIPcompress file\n"+
                            "\t Uses GZIP compression to compress"+
                            "the file to test.gz"
            );
            System.exit(1);
        }

        BufferedReader in=new BufferedReader(
                new FileReader(args[0]));
        BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(
                        new FileOutputStream("test.gz")));
        System.out.println("writing file");
        int c;
        //写入压缩文件
        while ((c=in.read())!=-1){
            out.write(c);
        }
        in.close();
        out.close();
        System.out.println("Reading file");
        BufferedReader in2=new BufferedReader(
                new InputStreamReader(new GZIPInputStream(
                        new FileInputStream("test.gz"))));
        String s;
        //读取压缩文件
        while ((s=in2.readLine())!=null)
            System.out.println(s);
    }

}
