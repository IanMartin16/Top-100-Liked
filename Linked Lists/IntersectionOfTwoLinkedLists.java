class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {
            // When pointerA reaches the end of list A, redirect it to the head of list B
            pointerA = (pointerA == null) ? headB : pointerA.next;
            // When pointerB reaches the end of list B, redirect it to the head of list A
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // At this point, pointerA and pointerB are either both null (no intersection) or both point to the intersection node
        return pointerA;
    }

    public static void main(String[] args) {
        // Create list nodes for testing
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        Solution solution = new Solution();
        ListNode intersection = solution.getIntersectionNode(headA, headB);
        
        if (intersection != null) {
            System.out.println("The intersection node's value is: " + intersection.val);
        } else {
            System.out.println("There is no intersection.");
        }
    }
}


//Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
//If the two linked lists have no intersection at all, return null.

//For example, the following two linked lists begin to intersect at node c1: