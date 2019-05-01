package file.IOTypicalUse;

import java.io.*;

public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in=new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("TestEOF.java")
                )
        );
        //使用available查看还有多少可供存取的字符
        //available的工作方式会随着所读取的媒介类型的不同而有所不同，对于不同类型的流要谨慎使用
        while (in.available()!=0){
            System.out.print((char)in.readByte());
        }
    }
}
