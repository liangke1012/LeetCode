package offerTest.demo20220219;


/**
给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 **/

public class PartitionLst {
    public static void main(String[] args) {

    }

    public static ListNode partition(ListNode head, int x){
        if(head == null){
            return head;
        }
        ListNode prev = head,curr = head.next;
        while(curr != null){
            if(curr.val < x){
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                curr = prev.next;
            }else{
                prev = prev.next;
                curr = curr.next;
            }
        }
        return head;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

}


