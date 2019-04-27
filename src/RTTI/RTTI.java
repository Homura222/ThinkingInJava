package RTTI;

class Userful{
    public void f(){}
    public void g(){}
}
class MoreUseful extends Userful{
    public void f(){}
    public void g(){ }
    public void u(){}
    public void v(){}
    public void w(){}
}
public class RTTI {
    public static void main(String[] args){
        Userful [] x={
                new Userful(),
                new MoreUseful()
        };
        x[0].f();
        x[1].g();

        ((MoreUseful)x[1]).u();
        //返回出错信息
        ((MoreUseful)x[0]).u();
    }
}
