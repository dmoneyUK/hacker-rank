package leetcode.amazon;

import java.util.HashMap;
import java.util.Map;

public class LRUCache implements MyCache {
    
    private LinkedNode dummyHead;
    private LinkedNode dummyTail;
    private Map<Integer, LinkedNode> cache = new HashMap<>();
    private int capacity;
    private int count;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead = new LinkedNode();
        dummyTail = new LinkedNode();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }
    
    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        
        removeNode(node);
        addNode(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        
        LinkedNode existed = cache.get(key);
        if (existed != null) {
            removeNode(existed);
        } else {
            count++;
            if (count > capacity) {
                cache.remove(dummyTail.pre.key);
                removeNode(dummyTail.pre);
            }
        }
        LinkedNode node = new LinkedNode(key, value);
        cache.put(key, node);
        addNode(node);
        
    }
    
    public void addNode(LinkedNode node) {
        LinkedNode oldHead = dummyHead.next;
        dummyHead.next = node;
        node.next = oldHead;
        oldHead.pre = node;
        node.pre = dummyHead;
    }
    
    public void removeNode(LinkedNode node) {
        LinkedNode next = node.next;
        LinkedNode pre = node.pre;
        pre.next = next;
        next.pre = pre;
    }
    
    class LinkedNode {
        private int key;
        private int value;
        private LinkedNode pre;
        private LinkedNode next;
        
        public LinkedNode() {
        }
        
        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public static void main(String args[]) {
        MyCache cache = new MonitoredCache(new LRUCache(2));
        cache.get(2);
        cache.put(2, 6);
        cache.get(1);
        cache.put(1, 5);
        cache.put(1, 2);
        cache.get(1);
        cache.get(2);
    }
}

interface MyCache {
    
    int get(int key);
    
    void put(int key, int value);
}

abstract class MyCacheDecorator implements MyCache {
    
    private MyCache cacheToBeDecorated;
    
    public MyCacheDecorator(MyCache cache) {
        cacheToBeDecorated = cache;
    }
    
    @Override
    public int get(int key) {
        return cacheToBeDecorated.get(key);
    }
    
    @Override
    public void put(int key, int value) {
        cacheToBeDecorated.put(key, value);
    }
}

class MonitoredCache extends MyCacheDecorator {
    
    public MonitoredCache(MyCache cache) {
        super(cache);
    }
    
    @Override
    public int get(int key) {
        int ans = super.get(key);
        System.out.println(ans);
        return ans;
        
    }
    
    @Override
    public void put(int key, int value) {
        super.put(key, value);
        System.out.println("null");
    }
    
}
