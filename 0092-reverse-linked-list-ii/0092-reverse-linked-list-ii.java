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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        int pos = 1;
        ListNode before = null;
        ListNode temp = head;
        while(pos<left){
            before = temp;
            temp = temp.next;
            pos++;
            continue;
        }

        ListNode curr = temp;
        ListNode prev = null;
        ListNode next;
        while(pos<=right){
            next = curr.next;
            curr.next =prev;
            prev = curr;
            curr = next;
            pos++;
        }

        
        temp.next = curr;
        if(before != null){
            before.next = prev;
            return head;
        }
        return prev;
    }
}