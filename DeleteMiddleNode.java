class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DeleteMiddleNode {
    // Function to delete the middle node
    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // If there's no node or only one node
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // To keep track of the previous node

        // Move fast pointer by 2 steps and slow pointer by 1 step
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        // Now 'slow' is at the middle node, and 'prev' is the node before it
        if (prev != null) {
            prev.next = slow.next; // Delete the middle node
        }

        return head;
    }

    // Function to print a linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Function to create a linked list from an array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // Example Input
        int[] arr = {1, 2, 3, 4, 5}; 

        // Create linked list
        ListNode head = createList(arr);
        System.out.print("Original List: ");
        printList(head);

        // Delete middle node and print the list
        head = deleteMiddle(head);
        System.out.print("After Deleting Middle Node: ");
        printList(head);
    }
}
