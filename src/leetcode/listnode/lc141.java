package leetcode.listnode;

import java.util.HashSet;
import java.util.Set;

public class lc141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow!=fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * leetcode 142 给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
       ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos!=null){
            if(visited.contains(pos)){
                return pos;
            }else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
