/*

You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.

*/
import com.example.lib.ListNode;

class DeleteMiddleOfLinkedList {
    public static ListNode deleteMiddle(ListNode head) {

        ListNode current = head;
        int length = 0;
        while(current != null) {
            current = current.next;
            length++;
        }
        // System.out.println(length);
        
        if(length == 1) {
            return null;
        }
        if(length == 2) {
            head.next = null;
            return head;
        }

        ListNode midsPrev = head;
        for(int i=1; i<(length/2); i++) {
            midsPrev = midsPrev.next;
        }
        // System.out.println(midsPrev.val);
        
        ListNode midsNext = midsPrev.next.next;
        midsPrev.next.next = null;
        midsPrev.next = midsNext;
        
        return head;
    }
    public static void main(String[] args) {
        ListNode l = new ListNode(50);
        ListNode k = new ListNode(40, l);
        ListNode j = new ListNode(30, k);
        ListNode i = new ListNode(20, j);
        ListNode head = new ListNode(10, i);
        // p(head);
        head = deleteMiddle(head);
        p(head);
    }
    public static void p(ListNode current) {
        while(current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
