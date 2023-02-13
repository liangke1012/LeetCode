package JUC.LongAdderDemo;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

//需求：50个线程，每个线程100w次，计算总点赞数
class ClickNumber{
    int number = 0;
    public synchronized void add1(){
        number++;
    }

    AtomicLong atomicLong =  new AtomicLong(0);
    public void add2(){
        atomicLong.incrementAndGet();
    }

    LongAdder longAdder =new LongAdder();
    public void add3(){
        longAdder.increment();
    }

    LongAccumulator longAccumulator = new  LongAccumulator((x, y) -> x + y,0);
    public void add4(){
        longAccumulator.accumulate(1);
    }
}
