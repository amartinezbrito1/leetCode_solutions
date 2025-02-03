// Define ListNode class
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Define Solution class
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // variables for sum 
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // continue looping while l1 or l2 have nodes to process
        while (l1 != null || l2 != null) {
            // getting the value of current node if it exists or get 0 
            // if the condition at the beginning is met/not met.  then either grab the value or 0 
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;

            // creating a new node to store the current value grabbed
            current.next = new ListNode(sum % 10);
            current = current.next;

            // move to the next node IF lists are not empty
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    // reverse order in lists, the numbers are stored in reverse order in the linked lists eg. 342 is represented as [2,4,3]. this naturally aligns with how we perform addition from rift in standard arithmetic
}

public class MainClass {
    public static void main(String[] args) {
        // Create the first linked list: [2,4,3]
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create the second linked list: [5,6,4]
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Call the addTwoNumbers function
        ListNode result = new Solution().addTwoNumbers(l1, l2);
    }
}
