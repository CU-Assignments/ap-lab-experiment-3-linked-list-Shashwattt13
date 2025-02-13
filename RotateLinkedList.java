class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RotateLinkedList {
    // Function to rotate the linked list
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length and last node
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Make it a circular list
        tail.next = head;

        // Step 3: Find the new head and break the loop
        k = k % length; // Handle cases where k > length
        if (k == 0) {
            tail.next = null; // No rotation needed
            return head;
        }

        int newHeadPos = length - k;
        ListNode newTail = head;
        for (int i = 1; i < newHeadPos; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
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
        int k = 2;

        // Create linked list
        ListNode head = createList(arr);
        System.out.print("Original List: ");
        printList(head);

        // Rotate and print
        head = rotateRight(head, k);
        System.out.print("Rotated List: ");
        printList(head);
    }
}
