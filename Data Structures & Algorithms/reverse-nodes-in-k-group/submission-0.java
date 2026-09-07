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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode groupprev = dummy;

        while(true) {
            ListNode kth = getK(groupprev,k);
            if(kth == null) {
                break;
            }
            ListNode groupNext = kth.next;
            ListNode prev = kth.next;
            ListNode curr = groupprev.next;
            while(curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            ListNode tmp = groupprev.next;
            groupprev.next = kth;
            groupprev = tmp;
        }
        return dummy.next; 
    }

    public ListNode getK(ListNode node, int k) {
        while(node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}
