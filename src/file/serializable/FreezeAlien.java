package file.serializable;

import java.io.*;

public class FreezeAlien {
    //序列化信息到该文件
    public static void main(String[] args) throws Exception {
        ObjectOutput out=new ObjectOutputStream(
                new FileOutputStream("X.text"));
        Alien quellek=new Alien();
        out.writeObject(quellek);
    }
}
