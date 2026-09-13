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
    public void reverse(ListNode head, int times){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while(times>0 && curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            times--;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode left = head;
        ListNode res = null;
        int size = 2;
        ListNode prevLeft = null;
        while(true){
            ListNode right = left;
            for(int i = 0; i<size-1; i++){
                if(right == null){
                    break;
                }
                right = right.next;
            }

            if(right != null){
                ListNode nextLeft = right.next;
                reverse(left,size);
                if(prevLeft != null){
                    prevLeft.next = right;
                }
                prevLeft = left;
                left = nextLeft;
                if(res == null){
                    res = right;
                }
            }
            else{
                if(prevLeft != null){
                    prevLeft.next = left;
                }
                break;
            }
        }

        return res;
    }
}