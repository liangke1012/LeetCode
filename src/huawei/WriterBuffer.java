package huawei;

import java.util.*;

/**
 * 缓存请求上限为bufferCap，并给定一组操作operations[i] = [操作码op, para1,para2,para3],以及初始主存数据data
 * 内存写：op=1， operations[i] = [1,偏移para1, 长度para2，内容para3]
 *    按每8字节，分解为多个写请求，分解后后的写请求按地址从小到大放入缓存
 *        如果缓存请求个数达到上限，则采用先进先出的方式从缓存中取出最早的请求，把写请求写入主存，再把新请求放入缓存
 * 内存读：op=2,operations[i] = [2,偏移para1, 长度para2，0]
 *
 * 内存同步：op=3，operations[i] = [3,0,0,0],将缓存中的所有数据写请求都读出来并写入主存
 *
 **/
public class WriterBuffer {
    public static void main(String[] args) {
        int bufferCap = 5;
        int[][] operations = new int[][] {{1,35,2,100}, {1,0,40,255}, {1,11,10,81}, {1,16,12,173},{2,16,3,0}
        ,{2,0,3,0}};
        String data = "00000000000000000000000000000000000000000000000000000000000000000000000000000000";

        String res = memoryRWWithBuffer(bufferCap, operations, data);
        System.out.println(res);
    }
    static String memoryRWWithBuffer(int bufferCap, int[][] operations, String data){
        WBuffer wb = new WBuffer(data, bufferCap);
        for(int[] operation : operations) {
            int op = operation[0];
            if (op == 1){
                wb.write(operation);
            } else if (op == 2) {
                wb.read(operation);
            } else {
                wb.sync(operation);
            }
        }
        return wb.getMemDataStr();
    }

}

class WBuffer {

    //private static final Map<Integer, String> map = new HashMap<>();

    private final String[] memData;
    private final int cap;

    Deque<WriteReq> cache = new LinkedList<>();
    public WBuffer(String data, int bufferCap) {
        cap = bufferCap;
        //将data变成每2位一组的数组
        int size = data.length() / 2;
        memData = new String[size];
        for (int i = 0; i < data.length(); i += 2) {
            memData[i / 2] = data.substring(i, i + 2);
        }
//        for (int i = 0; i < 10; i++) {
//            map.put(i, String.valueOf(i));
//        }
//
//        for (int i = 10; i < 16; i++) {
//            char c = (char)('A' + i - 10);
//            map.put(i, String.valueOf(c));
//        }
    }

    public void write(int[] operation) {
        //按8字节拆分写
        List<WriteReq> writeReqList = splitReq(operation);
        if(cache.size() + writeReqList.size() <= cap) {
            writeReqList.forEach(e -> cache.offer(e));
            return;
        }
        int pollSize = cache.size() + writeReqList.size() - cap;
        while (pollSize > 0 && !cache.isEmpty()) {
            writeToMem();
            pollSize--;
        }
        writeReqList.forEach(e -> cache.offer(e));
    }

    private void writeToMem() {
        WriteReq writeReq = cache.poll();
        for (int i = writeReq.start; i < writeReq.end; i++) {
            memData[i] = writeReq.content;
        }
    }

    private List<WriteReq> splitReq(int[] operation) {
        List<WriteReq> writeReqList = new ArrayList<>();
        String content = String.format("%02x", operation[3]);
        for (int i = operation[1]; i < operation[1] + operation[2]; i += 8) {
            WriteReq writeReq = new WriteReq();
            writeReq.start = i;
            writeReq.end = Math.min(i + 8, operation[1] + operation[2]);
            writeReq.content = content;
            writeReqList.add(writeReq);
        }
        return writeReqList;
    }

    public void read(int[] operation) {
        //判断读范围是否在cache内
        WriteReq findWriteReq = null;
        Iterator<WriteReq> cacheIter = cache.iterator();
        while (cacheIter.hasNext()) {
            WriteReq writeReq = cacheIter.next();
            if (writeReq.end <= operation[1] || writeReq.start >= operation[1] + operation[2]) {
                //不重叠
                continue;
            }
            findWriteReq = writeReq;
        }
        if (findWriteReq == null) {
            return;
        }
        while (!cache.isEmpty() && cache.peek() != findWriteReq) {
            writeToMem();
        }
        while (!cache.isEmpty() && cache.peek() == findWriteReq) {
            writeToMem();
        }
    }

    public void sync(int[] operation) {
        while (!cache.isEmpty()) {
           writeToMem();
        }
    }

    public String getMemDataStr() {
        return String.join("", memData);
    }
}

class WriteReq{
    int start;
    int end;
    String content; // 转换后16进制字符串

}