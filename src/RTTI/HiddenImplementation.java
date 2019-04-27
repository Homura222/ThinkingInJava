package RTTI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HiddenImplementation {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        //不能转为c，因为这个包访问不到c
        callHiddenMethod(a,"g");
        callHiddenMethod(a,"u");
        callHiddenMethod(a,"v");
        callHiddenMethod(a,"w");
    }

    static void callHiddenMethod(Object a, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //getDeclaredMethods​()返回一个包含 方法对象的数组， 方法对象反映由 Class对象表示的类或接口的所有声明方法，包括public，protected，default（package）访问和私有方法，但不包括继承方法。
        Method g = a.getClass().getDeclaredMethod(methodName);
        //setAccessible​(boolean flag)
        //将此反射对象的 accessible标志设置为指示的布尔值。
        g.setAccessible(true);
        //invoke​(Object obj, Object... args)
        //在具有指定参数的指定对象上调用此 方法对象表示的基础方法。
        g.invoke(a);
    }
}
