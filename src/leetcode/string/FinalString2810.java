package leetcode.string;

import java.util.Deque;
import java.util.LinkedList;

public class FinalString2810 {
    public static void main(String[] args) {
        String str = "string";
        String res = finalString(str);
        System.out.println(res);
    }

    private static String finalString(String s) {
        Deque<Character> q = new LinkedList<>();
        boolean head = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != 'i') {
                if (head){
                    q.offerFirst(ch);
                } else {
                    q.offerLast(ch);
                }
            }else {
                head = !head;
            }
        }
        StringBuilder ans = new StringBuilder();
        if(head) {
            while (!q.isEmpty()) {
                ans.append(q.pollLast());
            }
        } else {
            while (!q.isEmpty()){
                ans.append(q.pollFirst());
            }
        }
        return ans.toString();
    }

}
