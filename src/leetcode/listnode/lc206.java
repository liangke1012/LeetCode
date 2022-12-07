package leetcode.listnode;

import java.util.List;

public class lc206 {
    public ListNode reverseList(ListNode head) {
       ListNode prev = null;
       ListNode cur = head;
       while (cur != null){
           ListNode next = cur.next;
           cur.next = prev;
           prev = cur;
           cur = next;
       }
       return prev;

    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                prev.next = list1;
                list1=list1.next;
            }else{
                prev.next = list2;
                list2=list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null?list2:list1;
        return prehead.next;

    }

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if(l == r){
            return lists[l];
        }
        if(l > r){
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));

    }
    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null){
            for (int i = 0; i < k && end != null; i++) {
                 end = end.next;
            }
            if(end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverseList(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    /**
     * leetcode 92 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
         ListNode dummpNode = new ListNode(0);
         dummpNode.next = head;
         ListNode pre = dummpNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;
        for (int i = 0; i < right-left+1; i++) {
           rightNode = rightNode.next;
        }
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;
        pre.next = null;
        rightNode.next = null;
        reverseList(leftNode);
        pre.next = rightNode;
        leftNode.next = cur;
        return dummpNode.next;
    }
}
