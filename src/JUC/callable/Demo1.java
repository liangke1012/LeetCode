package JUC.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        new Thread(new MyThread1(),"AA").start();

        //new Thread(new MyThread2(),"AA").start();

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());

        FutureTask<Integer> futureTask1 = new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName()+" come in callable");
               return 1024;
        });

        //创建一个线程
        new Thread(futureTask1,"lucy").start();

        System.out.println(futureTask1.get());
    }
}

//实现Runnable接口
class MyThread1 implements Runnable {
    @Override
    public void run() {

    }
}

//实现Callable接口
class MyThread2 implements Callable {

    @Override
    public Integer call() throws Exception {
        return 200;
    }
}
