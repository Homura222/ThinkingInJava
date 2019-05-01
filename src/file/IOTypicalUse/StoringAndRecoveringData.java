package file.IOTypicalUse;

import java.io.*;

/**
 * 存储和恢复数据
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out=new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("Data.txt")
                )
        );
        //写入数据
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.close();
        //读取数据
        DataInputStream in=new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("Data.txt")
                )
        );
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
    }
}
