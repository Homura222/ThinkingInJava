package file.IOTypicalUse;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * 格式化输入
 */
public class FormattedMemoryInput {
    public static void main(String[] args) {
        try {
            DataInputStream in = null;
            //用InputStream以字节的形式读取任何数据
            in = new DataInputStream(new ByteArrayInputStream(
                    BufferedInputFile.read(
                            "FormattedMemoryInput.java"
                    ).getBytes()));
            while (true) {
                System.out.print((char) in.readByte());
            }
        } catch (IOException e) {
            System.out.print("End of stream");
        }
    }
}
