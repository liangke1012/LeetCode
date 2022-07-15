package Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestNewInstance {
    public void work(){
        System.out.println("-----------");
    }
    public TestNewInstance work(String a,Integer b){
        System.out.println(a + b);
        return this;
    }
    public void work(Integer b, int c ){
        System.out.println(b + c);
    }

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = TestNewInstance.class;
        System.out.println(clazz);
        Method method1 = clazz.getMethod("work", new Class[]{});
        Method method2 = clazz.getMethod("work", new Class[]{String.class, Integer.class});
        Method method3 = clazz.getMethod("work", new Class[]{Integer.class, int.class});
        Object invokeTest = clazz.newInstance();
        Object result1 = method1.invoke(invokeTest, new Object[]{});
        Object result2 = method2.invoke(invokeTest, new Object[]{"aaaa",new Integer(10)});
        Object result3 = method3.invoke(invokeTest, new Object[]{3,new Integer(4)});
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }
}
