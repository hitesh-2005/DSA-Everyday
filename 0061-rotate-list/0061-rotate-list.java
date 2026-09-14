/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int size = 1;
        ListNode last = head;
        while(last.next!=null){
            last = last.next;
            size++;
        }
        
        k = k % size;
        if(k == 0){
            return head;
        }

        ListNode prev = head;
        for(int i = 1; i<size-k; i++){
            prev = prev.next;
        }

        last.next = head;
        ListNode newHead = prev.next;
        prev.next = null;
        return newHead;
    }
    
}