package file.util;

import java.io.*;

/**
 * 读取二进制文件
 */
public class BinaryFile {
    //文件读取
    public static byte[] read(File bFile) throws IOException {
        BufferedInputStream bf=new BufferedInputStream(
                new FileInputStream(bFile)
        );
        try {
            //二进制形式存放读取数据
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        }finally {
            bf.close();
        }
    }
    //文件名调用
    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }
    public static void main(String[] args) throws IOException {
        String s="BinaryFile.java";
        read(s);
    }
}
