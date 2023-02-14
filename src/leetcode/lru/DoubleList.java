package leetcode.lru;

public class DoubleList<K,V>{
    private Node1<K, V> head, tail;
    private Integer size;

    public DoubleList() {
        head = new Node1<>(null, null);
        tail = new Node1<>(null, null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 新节点加到尾部
    public void addLast(Node1<K, V> node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    // 删除头节点并返回，用于从map中删除
    public Node1<K, V> removeFromHead() {
        if (head.next == tail) {
            return null;
        }
        Node1<K, V> node = head.next;
        removeNode(node);
        return node;
    }

    // 中间节点被访问，需要移到尾部，先删再加
    public void removeNode(Node1<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    // 返回链表大小
    public Integer size() {
        return size;
    }
}


