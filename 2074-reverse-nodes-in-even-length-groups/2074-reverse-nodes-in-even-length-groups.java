/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}ListNode right = left;
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reverse(ListNode head, int times){
        ListNode curr = head;
        ListNode prev = null;

        while(times > 0 && curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            times--;
        }
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode left = head;
        ListNode prevLeft = null;
        ListNode res = null;
        int size = 1;
        while(true){
            ListNode right = left;
            int actualSize = 1;

            while(actualSize < size && right.next != null){
                right = right.next;
                actualSize++;
            }

            ListNode nextLeft = right.next;
            ListNode groupHead = left;

            if(actualSize % 2 == 0){
                reverse(left, actualSize);

                if(prevLeft != null){
                    prevLeft.next = right;
                }

                if(res == null){
                    res = right;
                }

                prevLeft = groupHead;
            }
            else{
                if(prevLeft != null){
                    prevLeft.next = groupHead;
                }

                if(res == null){
                    res = groupHead;
                }

                prevLeft = right;
            }
            left = nextLeft;
            size++;

            if(left == null){
                break;
            }
        }
        return res;
    }
}