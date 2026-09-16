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
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revL1 = reverse(l1);
        ListNode revL2 = reverse(l2);

        ListNode prev = null;
        ListNode res = null;
        int carry = 0;
        while(revL1 != null || revL2 != null || carry != 0){
            int sum = carry;
            if(revL1 != null){
                sum += revL1.val;
                revL1 = revL1.next;
            }

            if(revL2 != null){
                sum += revL2.val;
                revL2 = revL2.next;
            }

            ListNode node = new ListNode(sum%10);
            if(res == null){
                res = node;
            }
            else{
                prev.next = node;
            }
            prev = node;
            carry = sum/10;
        }
        return reverse(res);
    }
}