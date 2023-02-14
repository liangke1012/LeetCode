package leetcode.lru;

public interface Loader<K, V> {
    V load(K key);
}