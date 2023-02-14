package leetcode.lru;

public class Node1<K,V> {
    public K key;
    public V val;
    public Node1<K, V> prev;
    public Node1<K, V> next;
    public Node1(K key, V val) {
        this.key = key;
        this.val = val;
    }
}
