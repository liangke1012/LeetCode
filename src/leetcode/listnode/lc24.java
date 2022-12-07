package leetcode.listnode;



public class lc24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummpyHead = new ListNode(0);
        dummpyHead.next = head;
        ListNode temp = dummpyHead;
        while(temp.next!=null && temp.next.next!= null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummpyHead.next;
    }


}
