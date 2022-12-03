package leetcode.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDemo {
    private int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;

    public LRUCacheDemo(int cacheSize) {
        this.cacheSize = cacheSize;//坑位
        map = new HashMap<>();//查找
        doubleLinkedList = new DoubleLinkedList<>();
    }
    public int get(int key) {
       if(!map.containsKey(key)){
           return -1;
       }
       Node<Integer,Integer> node = map.get(key);
       doubleLinkedList.removeNode(node);
       doubleLinkedList.addHead(node);
       return node.value;
    }

    public void put(int key, int value) {
      if(map.containsKey(key)){
          Node<Integer, Integer> node = map.get(key);
          node.value = value;
          map.put(key,node);

          doubleLinkedList.removeNode(node);
          doubleLinkedList.addHead(node);
      }else{
          if(map.size() == cacheSize){
              Node listLast = doubleLinkedList.getLast();
              map.remove(listLast.key);
              doubleLinkedList.removeNode(listLast);
          }
          Node<Integer,Integer> node = new Node<>(key,value);
          map.put(key,node);
          doubleLinkedList.addHead(node);
      }
    }

    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);

        lruCacheDemo.put(1, 1);
        lruCacheDemo.put(2, 2);
        lruCacheDemo.put(3, 3);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(4, 1);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(5, 1);
        System.out.println(lruCacheDemo.map.keySet());

    }

}
