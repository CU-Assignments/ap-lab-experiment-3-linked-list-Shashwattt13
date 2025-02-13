public class LinkedList {
    Node head; // Head of the list

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to print the linked list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Creating nodes
        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        
        // Linking nodes
        list.head.next = second;
        second.next = third;
        
        // Printing the list
        list.printList();
    }
}
 
    
