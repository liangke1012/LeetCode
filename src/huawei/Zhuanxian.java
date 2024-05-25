package huawei;

import edu.princeton.cs.algs4.In;

import java.util.*;
import java.util.stream.Collectors;

/**
 * int[][] configs,config[i]=[id1,id2],表示端口id1和id2存在一条专线，后面的请求无法执行add操作
 * batchReq[i]:[Opt,id1,id2]:Opt只有2种取值，‘a’:新增专线通道，‘d'删除专用通道
 * 执行后会得到一个最终配置
 * 输出：得到这个最终配置最少的命令
 *
 */
public class Zhuanxian {
    public static void main(String[] args) {
        int[][] configs = {{2,3},{4,5}};
        List<CmdInfo> batchReqs = new ArrayList<>();
        batchReqs.add(new CmdInfo('a', 0, 1));
        batchReqs.add(new CmdInfo('a', 5, 6));
        batchReqs.add(new CmdInfo('d', 0, 1));
        batchReqs.add(new CmdInfo('d', 1, 2));
        batchReqs.add(new CmdInfo('a', 0, 6));
        batchReqs.add(new CmdInfo('d', 4, 5));
        batchReqs.add(new CmdInfo('a', 1, 4));
        List<CmdInfo> cmdInfos = batchCommit(configs, batchReqs);
        System.out.println(cmdInfos);
    }

    private static List<CmdInfo> batchCommit(int[][] configs, List<CmdInfo> batchReqs) {
        List<CmdInfo> res = new ArrayList<>(batchReqs.size());
        Set<Integer> used = new HashSet<>();
        List<PortInfo> oriPortInfos = new ArrayList<>();
        List<PortInfo> curPortInfos = new ArrayList<>();
        for (int[] config : configs) {
            used.add(config[0]);
            used.add(config[1]);
            oriPortInfos.add(new PortInfo(config[0], config[1]));
            curPortInfos.add(new PortInfo(config[0], config[1]));
        }
        for (CmdInfo batchReq : batchReqs) {
            PortInfo portInfo = new PortInfo(batchReq.src, batchReq.dsc);
            if (batchReq.opType == 'a') {
                if (!used.contains(batchReq.src) && !used.contains(batchReq.dsc)) {
                    used.add(batchReq.src);
                    used.add(batchReq.dsc);
                    curPortInfos.add(portInfo);
                }
            } else {
                if (used.contains(batchReq.src) && used.contains(batchReq.dsc)
                    && curPortInfos.contains(portInfo)) {
                    used.remove(batchReq.src);
                    used.remove(batchReq.dsc);
                    curPortInfos.remove(portInfo);
                }
            }
        }
        //删除
        List<PortInfo> copyOriPortInfos = new ArrayList<>(oriPortInfos);
        List<PortInfo> copyCurPortInfos = new ArrayList<>(curPortInfos);
        copyOriPortInfos.removeAll(copyCurPortInfos);
        if (!copyOriPortInfos.isEmpty()) {
            for (PortInfo oriPortInfo : copyOriPortInfos) {
                CmdInfo cmdInfo = new CmdInfo();
                cmdInfo.opType = 'd';
                cmdInfo.src = oriPortInfo.getId1();
                cmdInfo.dsc = oriPortInfo.getId2();
                res.add(cmdInfo);
            }
        }

        //add
        List<PortInfo> copyOriPortInfos2 = new ArrayList<>(oriPortInfos);
        List<PortInfo> copyCurPortInfos2 = new ArrayList<>(curPortInfos);
        copyCurPortInfos2.removeAll(copyOriPortInfos2);
        if (!copyCurPortInfos2.isEmpty()) {
            for (PortInfo oriPortInfo : copyCurPortInfos2) {
                CmdInfo cmdInfo = new CmdInfo();
                cmdInfo.opType = 'a';
                cmdInfo.src = oriPortInfo.getId1();
                cmdInfo.dsc = oriPortInfo.getId2();
                res.add(cmdInfo);
            }
        }
        if (!res.isEmpty()) {
            res = res.stream().sorted(new Comparator<CmdInfo>() {
                @Override
                public int compare(CmdInfo o1, CmdInfo o2) {
                    if (o1.opType != o2.opType) {
                        return o2.opType - o1.opType;
                    }
                    if (o1.src != o2.src) {
                        return o1.src - o2.src;
                    }
                    return 0;
                }
            }).collect(Collectors.toList());
        }
        return res;
    }
}

class CmdInfo{
    char opType;
    int src;
    int dsc;

    public CmdInfo(char opType, int src, int dsc) {
        this.opType = opType;
        this.src = src;
        this.dsc = dsc;
    }

    public CmdInfo() {
    }

    @Override
    public String toString() {
        return "CmdInfo{" +
                "opType=" + opType +
                ", src=" + src +
                ", dsc=" + dsc +
                '}';
    }
}

class PortInfo {
    int id1;
    int id2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PortInfo portInfo = (PortInfo) o;
        return id1 == portInfo.id1 && id2 == portInfo.id2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id1, id2);
    }

    public PortInfo(int id1, int id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    public int getId1() {
        return id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }
}
