package leetcode.backtract;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 子集问题
 */
public class lc93 {

    public static void main(String[] args) {
        String s = "2552551113";
        List<String> res = restoreIpAddresses(s);
        System.out.println(res.toString());
    }
    public static List<String> restoreIpAddresses(String s) {
        int len = s.length();
       List<String> res = new ArrayList<>();
       if(s.length() < 4 || s.length() > 12){
           return res;
       }
        Deque<String> path = new ArrayDeque<>(4);
        int splitTimes = 0;
        dfs(s, len, splitTimes, 0, path, res);
        return res;

    }

    private static void dfs(String s, int len, int splitTimes, int begin, Deque<String> path, List<String> res) {
       if(begin == len){
           if(splitTimes == 4){
               res.add(String.join(".",path));
           }
           return;
       }
       if(len-begin<(4-splitTimes) || len-begin > 3*(4-splitTimes)){
           return;
       }
        for (int i = 0; i < 3; i++) {
            if(begin + i >= len){
                break;
            }
            int ipSegment = judgeIfIp(s,begin,begin + i);
            if(ipSegment != -1){
                path.addLast(ipSegment+"");
                dfs(s,len,splitTimes+1,begin+i+1,path,res);
                path.removeLast();
            }
        }
    }

    private static int judgeIfIp(String s, int begin, int end) {
        int len = end - begin +1;
        if(len > 1 && s.charAt(begin) == '0'){
            return -1;
        }
        // 转成 int 类型
        int res = 0;
        for (int i = begin; i <= end; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }

        if (res > 255) {
            return -1;
        }
        return res;
    }
}
