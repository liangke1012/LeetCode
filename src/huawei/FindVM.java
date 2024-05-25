package huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
cpaacities[i] 表示编号i的物理机内存大小
request[]表示部署的虚拟机需要的内存大小
分配规则：
优先选择内存最大的；
 如果多台物理机内存相等，则选择不熟虚拟机最少的
 如果数量还相等，则选择其中编号最小的的物理机
*/
public class FindVM {
    public static void main(String[] args) {
        int[] capacites = {3,4,7,7,8,10};
        int[] request = {5,4,3,2,5,1};
        int[] res = findVm(capacites, request);
        System.out.println(Arrays.toString(res));
    }

    private static int[] findVm(int[] capacites, int[] request) {
        PriorityQueue<VmInfo> vmInfos = new PriorityQueue<>(new Comparator<VmInfo>() {
            @Override
            public int compare(VmInfo o1, VmInfo o2) {
                if (o1.getMemory() != o2.getMemory()) {
                    return o2.getMemory() - o1.getMemory();
                }
                if (o1.getSucNum() != o2.getSucNum()) {
                    return o1.getSucNum() - o2.getSucNum();
                }
                if (o1.getCode() != o2.getCode()) {
                    return o1.getCode() - o2.getCode();
                }
                return 0;
            }
        });
        int[] res = new int[request.length];
        for (int i = 0; i < capacites.length; i++) {
            vmInfos.add(new VmInfo(i, capacites[i], 0));
        }
        for (int i = 0; i < request.length; i++) {
            if (vmInfos.peek().getMemory() >= request[i]) {
                VmInfo poll = vmInfos.poll();
                poll.setSucNum(poll.getSucNum() + 1);
                poll.setMemory(poll.getMemory() - request[i]);
                res[i] = poll.getCode();
                vmInfos.add(poll);
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}

class VmInfo{
    int code;
    int Memory;
    int sucNum;

    public VmInfo(int code, int memory, int sucNum) {
        this.code = code;
        Memory = memory;
        this.sucNum = sucNum;
    }

    public int getCode() {
        return code;
    }

    public int getMemory() {
        return Memory;
    }

    public int getSucNum() {
        return sucNum;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMemory(int memory) {
        Memory = memory;
    }

    public void setSucNum(int sucNum) {
        this.sucNum = sucNum;
    }
}
