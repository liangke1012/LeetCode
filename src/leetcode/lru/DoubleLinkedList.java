package leetcode.lru;

public class DoubleLinkedList<K,V> {
    Node<K,V> head;
    Node<K,V> tail;

    public DoubleLinkedList() {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    // 3.添加到头
    public void addHead(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // 4.删除节点
    public void removeNode(Node<K, V> node){
       node.next.prev = node.prev;
       node.prev.next = node.next;
       node.prev = null;
       node.next = null;
    }
    // 5.获得最后一个节点
    public Node getLast() {
        return tail.prev;
    }
}
