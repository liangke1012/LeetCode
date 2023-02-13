package JUC.LongAdderDemo;

import java.util.concurrent.CountDownLatch;

public class AccumulatorCompareDemo {
    public static final int _1W = 1000000;
    public static final int threadNumber = 50;
    public static void main(String[] args) throws InterruptedException {

        ClickNumber clickNumber = new ClickNumber();
        Long startTime;
        Long endTime;
        CountDownLatch countDownLatch1 = new CountDownLatch(50);
        CountDownLatch countDownLatch2 = new CountDownLatch(50);
        CountDownLatch countDownLatch3 = new CountDownLatch(50);
        CountDownLatch countDownLatch4 = new CountDownLatch(50);

//        startTime = System.currentTimeMillis();
//        for(int i = 1;i <= threadNumber;i ++){
//            new Thread(()->{
//                try {
//                    for(int j = 1;j <=_1W;j++){
//                        clickNumber.add1();
//                    }
//                } finally {
//                    countDownLatch1.countDown();
//                }
//            },String.valueOf(i)).start();
//        }
//        countDownLatch1.await();
//        endTime = System.currentTimeMillis();
//        System.out.println("costTime---"+(endTime-startTime)+"毫秒"+"\t"+"synchronized---"+clickNumber.number);

//        startTime = System.currentTimeMillis();
//        for(int i = 1;i <= threadNumber;i ++){
//            new Thread(()->{
//                try {
//                    for(int j = 1;j <=_1W;j++){
//                        clickNumber.add2();
//                    }
//                } finally {
//                    countDownLatch2.countDown();
//                }
//            },String.valueOf(i)).start();
//        }
//        countDownLatch2.await();
//        endTime = System.currentTimeMillis();
//        System.out.println("costTime---"+(endTime-startTime)+"毫秒"+"\t"+"atomicLong---"+clickNumber.atomicLong);
//
        startTime = System.currentTimeMillis();
        for(int i = 1;i <= threadNumber;i ++){
            new Thread(()->{
                try {
                    for(int j = 1;j <=_1W;j++){
                        clickNumber.add3();
                    }
                } finally {
                    countDownLatch3.countDown();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch3.await();
        endTime = System.currentTimeMillis();
        System.out.println("costTime---"+(endTime-startTime)+"毫秒"+"\t"+"LongAdder---"+clickNumber.longAdder.sum());
//
//        startTime = System.currentTimeMillis();
//        for(int i = 1;i <= threadNumber;i ++){
//            new Thread(()->{
//                try {
//                    for(int j = 1;j <=_1W;j++){
//                        clickNumber.add4();
//                    }
//                } finally {
//                    countDownLatch4.countDown();
//                }
//            },String.valueOf(i)).start();
//        }
//        countDownLatch4.await();
//        endTime = System.currentTimeMillis();
//        System.out.println("costTime---"+(endTime-startTime)+"毫秒"+"\t"+"LongAccumulator---"+clickNumber.longAccumulator.longValue());
    }
    //costTime---2205毫秒  synchronized---50000000
    //costTime---435毫秒  atomicLong---50000000
    //costTime---86毫秒  LongAdder---50000000
    //costTime---84毫秒  LongAccumulator---50000000
}//印证了阿里卡法手册中说的 【如果是JDK8，推荐使用LongAdder对象，比AtomicLong性能更好（减少乐观锁的重试次数）】


