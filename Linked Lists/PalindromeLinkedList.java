class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        
        ListNode slow = head, fast = head;
        Stack<Integer> stack = new Stack<>();

        // Push elements from the first half of the linked list onto the stack
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // If there are odd number of elements in the list, skip the middle element
        if (fast != null) {
            slow = slow.next;
        }

        // Compare the elements in the second half with the elements in the stack
        while (slow != null) {
            int top = stack.pop();
            
            if (top != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a palindrome linked list: 1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        boolean result = solution.isPalindrome(head);
        System.out.println("Is palindrome: " + result);  // Output: Is palindrome: true
    }
}


//Given the head of a singly linked list, return true if it is a 
//palindrome
 //or false otherwise.