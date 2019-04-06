package leetcode.amazon;

import lombok.Setter;

public class LRUCache {
    
    private LinkedNode dummyHead;
    private LinkedNode dummyTail;
    
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
    
    @Setter
    class LinkedNode {
        private int key;
        private int value;
        private LinkedNode pre;
        private LinkedNode next;
        
        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
}
