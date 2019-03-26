package leetcode.amazon;

public class AddTwoNums {
    public class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) { val = x; }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        
        while (p != null && q != null) {
            int sum = p.val + q.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            p = p.next;
            q = q.next;
        }
        
        while (p != null) {
            int sum = p.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            p = p.next;
        }
        
        while (q != null) {
            int sum = q.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            q = q.next;
        }
        
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
