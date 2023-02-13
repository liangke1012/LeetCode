import java.util.*;

class MyThread{
    int num = 1;
    int flag = 1;

    public void increase_1(){
        while(num < 99){
            synchronized (this){
                while (flag != 1){
                    try{
                        wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + (num++) );
                flag = 2;
                notifyAll();
            }
        }
    }

    public void increase_2(){
        while(num < 99){
            synchronized (this){
                while (flag != 2){
                    try{
                        wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + (num++) );
                flag = 3;
                notifyAll();
            }
        }
    }

    public void increase_3(){
        while(num < 100){
            synchronized (this){
                while (flag != 3){
                    try{
                        wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + (num++) );
                flag = 1;
                notifyAll();
            }
        }
    }

}
public class Test1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(() ->{
           myThread.increase_1();
        });
        Thread t2 = new Thread(() ->{
            myThread.increase_2();
        });
        Thread t3 = new Thread(() ->{
            myThread.increase_3();
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
