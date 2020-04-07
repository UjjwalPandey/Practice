/*  Remove Nth Node from List End
    Problem Description
    Given a linked list A, remove the B-th node from the end of list and return its head.
    For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end,
    the linked list becomes 1->2->3->5.

    NOTE: If B is greater than the size of the list, remove the first node of the list.
    NOTE: Try doing it using constant additional space.

    Problem Constraints
    1 <= |A| <= 106

    Input Format
    The first argument of input contains a pointer to the head of the linked list.
    The second argument of input contains the integer B.

    Output Format
    Return the head of the linked list after deleting the B-th element from the end.


    Example Input
    Input 1:
    A = [1, 2, 3, 4, 5]
    B = 2
    Input 2:
    A = [1]
    B = 1


    Example Output
    Output 1:
    [1, 2, 3, 5]
    Output 2:
     []


    Example Explanation
    In the first example, 4 is the second last element. In the second example, 1 is the first and the last element.

 */
package LinkedList;

public class RemoveNthNodeFromListEnd {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public static void main(String[] args) {
        ListNode l;
        l = new ListNode(1);
        printList(l);
        printList(removeNthFromEnd(l, 1));
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        printList(l);
        printList(removeNthFromEnd(l, 2));
    }

    private static void printList(ListNode removeNthFromEnd) {
        ListNode temp = removeNthFromEnd;
        while (temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode fast = A, slow = A;
        int counter = 0;
        while (fast.next != null && counter < B){
            fast = fast.next;
            counter++;
        }
        if(counter < B){
            A = A.next;
            return A;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next != null)
            slow.next = slow.next.next;
        return A;
    }
}
