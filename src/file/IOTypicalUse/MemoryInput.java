package file.IOTypicalUse;

import java.io.IOException;
import java.io.StringReader;

/**
 * 从内存输入
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        //返回的String结果被用于创建StringReader对象，然后调用read读取每一个字符
        StringReader in=new StringReader(BufferedInputFile.read("MemoryInput.java"));
        int c;
        while ((c=in.read())!=-1){
            //转型 然后正确打印
            System.out.print((char) c);
        }
    }
}
