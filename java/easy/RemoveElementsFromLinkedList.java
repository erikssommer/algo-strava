package java.easy;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of
 * the linked list that has Node.val == val, and return the new head.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * 
 * Example 2:
 * 
 * Input: head = [], val = 1
 * Output: []
 * 
 * Example 3:
 * 
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveElementsFromLinkedList {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;

        ListNode prev = null;

        while (curr != null) {
            if (curr.val == val) {
                if (curr == head) {
                    head = head.next;
                } else if (curr.next == null) {
                    curr = prev;
                    prev.next = null;
                } else {
                    prev.next = curr.next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}