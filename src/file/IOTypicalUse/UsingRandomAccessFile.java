package file.IOTypicalUse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读写随机访问文件
 */
public class UsingRandomAccessFile {
    static String file="rtest.dat";
    //打开一个文件
    static void display() throws IOException {
        //只读
        RandomAccessFile rf=new RandomAccessFile(file,"r");
        //遍历double类型
        for (int i=0;i<7;i++){
            System.out.println(
                    "value"+i+":"+rf.readDouble()
            );
        }
        //遍历utf
        System.out.println(rf.readUTF());
        rf.close();
    }
    public static void main(String[] args) throws IOException {
        //读写
        RandomAccessFile rf=new RandomAccessFile(file,"rw");
        //写double
        for (int i=0;i<7;i++){
            rf.writeDouble(i*1.414);
        }
        rf.writeUTF("The end of the file");
        //查找第五个双精度值 double8字节长
        rf.seek(5*8);
        //重写第五个
        rf.writeDouble(47.001);
        rf.close();
        display();
    }
}
