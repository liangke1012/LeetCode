package leetcode.listnode;

public class DeleteDuplicates {
    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummp = new ListNode(0);
        dummp.next = head;
        ListNode current = dummp;
        while(current.next != null && current.next.next != null){
            int x = current.next.val;
            if(x != current.next.next.val){
                current = current.next;
            }else{
                while(current.next != null && current.next.val == x){
                    current.next = current.next.next;
                }
            }
        }
        return dummp.next;
    }

    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode cur = head;
        while (cur.next!= null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}
