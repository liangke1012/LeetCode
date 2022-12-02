package JUC.sync;

public class ReEnterLockDemo {
    // synchronized 同步代码块可重入演示
    static Object objectLockA = new Object();

    public static void main(String[] args) {
        m1();
    }

    public static void m1() {
        new Thread(() -> {
            synchronized (objectLockA) {
                System.out.println(Thread.currentThread().getName() + "\t" + "------外层调用");
                synchronized (objectLockA) {
                    System.out.println(Thread.currentThread().getName() + "\t" + "------中层调用");
                    synchronized (objectLockA) {
                        System.out.println(Thread.currentThread().getName() + "\t" + "------内层调用");
                    }
                }
            }
        }, "t1").start();

    }
}
