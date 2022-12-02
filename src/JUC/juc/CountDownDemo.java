package JUC.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownDemo {
    public static void main(String[] args) throws InterruptedException{

        CountDownLatch countDownLatch = new CountDownLatch(6);

        //6个同学陆续离开教室之后
        for (int i = 1; i <=6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 号同学离开了教室");

                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+" 班长锁门走人了");

    }
}
