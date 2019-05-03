package file.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class ThawAlient {
    public static void main(String[] args) throws Exception {
        //在目标地址里面找不到文件则报错
        ObjectInputStream in=new ObjectInputStream(
                new FileInputStream(new File("X.text")));
        Object mystery=in.readObject();
        System.out.println(mystery.getClass());
    }
}
