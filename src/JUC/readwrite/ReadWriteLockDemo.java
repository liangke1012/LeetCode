package JUC.readwrite;

import java.util.concurrent.TimeUnit;

public class ReadWriteLockDemo {
    public static void main(String[] args) throws Exception{
        MyCache myCache = new MyCache();
        for (int i = 0; i < 6; i++) {
            final int num = i;
            new Thread( () ->{
              myCache.put(num +"",num+"");
            },String.valueOf(i)).start();
        }

        TimeUnit.MICROSECONDS.sleep(300);

        //创建线程取数据
        for (int i = 1; i <=5; i++) {
            final int num = i;
            new Thread(()->{
                myCache.get(num+"");
            },String.valueOf(i)).start();
        }
    }
}
