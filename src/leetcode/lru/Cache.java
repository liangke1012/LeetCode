package leetcode.lru;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cache<K,V> {
    int maxSize;
    Loader<K,V> loader;

    private Map<K, Node1<K, V>> map;
    private DoubleList<K, V> data;

    private Lock lock;

    public Cache(int maxSize, Loader<K, V> loader) {
        this.maxSize= maxSize;
        this.loader = loader;
        map = new ConcurrentHashMap<>();
        data = new DoubleList<>();
        this.lock = new ReentrantLock();
    }

    public V get(K key) {
        this.lock.lock();
        try {
            if (!map.containsKey(key)) {
                // 不存在，由loader创建
                V val = this.loader.load(key);
                Node1<K, V> node = new Node1<>(key, val);
                // 添加前判断是否要驱逐
                if (data.size() == this.maxSize) {
                    resize();
                }
                addRecently(node);
                return val;
            }
            Node1<K, V> node = map.get(key);
            // 访问过
            makeRecently(key);
            return node.val;
        } finally {
            this.lock.unlock();
        }
    }

    // 最近访问过
    private void makeRecently(K key) {
        Node1<K, V> node = map.get(key);
        // 先删再加
        data.removeNode(node);
        data.addLast(node);
    }

    // 新加入的节点
    private void addRecently(Node1<K, V> node) {
        data.addLast(node);
        map.put(node.key, node);
    }

    // 达到容量阈值，lru驱逐
    private void resize() {
        Node1<K, V> node = data.removeFromHead();
        map.remove(node.key);
    }
}
