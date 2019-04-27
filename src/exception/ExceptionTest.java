package exception;

public class ExceptionTest {
    public static void main(String[] args) throws InterruptedException {
        //标准错误流，异常使用的信息流,与out的区别：
        //1. 颜色不一样
        //2. 不会重定向
        //3. 标准输出有缓存，标准出错没有缓存
        System.err.println("ERROR");
        System.err.println("ERROR2");
        System.err.println("ERROR3");
        System.err.println("ERROR4");
        System.out.println("YES");
        System.out.println("YES2");
        System.out.println("YES3");
        System.out.println("YES4");
    }
}
