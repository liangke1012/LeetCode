package JUC.locksupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    private static void lockSupportParkUnpark() {
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
            LockSupport.park(); // 线程 A 阻塞
            System.out.println(Thread.currentThread().getName() + "\t" + "------被唤醒");
        }, "A");
        a.start();

        new Thread(() -> {
            LockSupport.unpark(a); // B 线程唤醒线程 A
            System.out.println(Thread.currentThread().getName() + "\t" + "------通知");
        }, "B").start();
    }

    public static void main(String[] args) {
        lockSupportParkUnpark();
    }

}
