class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        
        // Detect if there is a cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // Cycle detected
            if (slow == fast) {
                // Find the entry point of the cycle
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        
        // No cycle found
        return null;
    }

    public static void main(String[] args) {
        // Test case 1: List with cycle
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // cycle

        Solution solution = new Solution();
        ListNode cycleNode = solution.detectCycle(head);
        if (cycleNode != null) {
            System.out.println("Cycle detected at node with value: " + cycleNode.val);
        } else {
            System.out.println("No cycle detected");
        }

        // Test case 2: List without cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        ListNode noCycleNode = solution.detectCycle(head2);
        if (noCycleNode != null) {
            System.out.println("Cycle detected at node with value: " + noCycleNode.val);
        } else {
            System.out.println("No cycle detected");
        }

        // Test case 3: Single node without cycle
        ListNode head3 = new ListNode(1);

        ListNode noCycleNode3 = solution.detectCycle(head3);
        if (noCycleNode3 != null) {
            System.out.println("Cycle detected at node with value: " + noCycleNode3.val);
        } else {
            System.out.println("No cycle detected");
        }

        // Test case 4: Two nodes with cycle
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = head4; // cycle

        ListNode cycleNode4 = solution.detectCycle(head4);
        if (cycleNode4 != null) {
            System.out.println("Cycle detected at node with value: " + cycleNode4.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}


//Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
//Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. 
//Note that pos is not passed as a parameter.

//Do not modify the linked list.