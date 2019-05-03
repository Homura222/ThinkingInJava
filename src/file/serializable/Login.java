package file.serializable;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Login implements Serializable {
    private Date data=new Date();
    private String username;
    private transient String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "data=" + data +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Login a=new Login("Hulk","myLittlePony");
        System.out.println("login a="+a);
        //序列化
        ObjectOutputStream o=new ObjectOutputStream(
               new FileOutputStream("Login.out"));
        o.writeObject(a);
        o.close();
        //睡1s
        TimeUnit.SECONDS.sleep(1);
        //反序列化
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("Login.out"));
        //data没有再生成即没有调用构造器直接恢复数据
        System.out.println("Recovering object at"+new Date());
        a= (Login) in.readObject();
        System.out.println("login a="+a);
    }
}
