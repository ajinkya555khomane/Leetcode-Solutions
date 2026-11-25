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
        if (head == null || head.next == null){
            return head;
        }

        //null
        // 1 -> null

        ListNode tail = null;
        int size = 0;
        ListNode curr = head;

        //1 2 null
        //    c
        //size = 2
        // t

        while (curr != null){
            tail = curr;
            curr = curr.next;
            size++;
        }

        // 1 2 3
        // 4
        // 3
        // 1
        
        // 1 2 3 4 5 6 7 8
        // k = 2
        // 7 8 1 2 3 4 5 6
        int newK = k % size;

        if (newK ==0){
            return head;
        }
        int diff = size - newK;

        int i = 0;

        curr = head;

        while (i < diff - 1){
            curr = curr.next;
            i++;
        }

        //curr -> 6
        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;
        return newHead;
    }
}