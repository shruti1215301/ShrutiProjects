package LinkedList;

public class LL {

    private Node head;
    private int size;

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert at the end of the list
    public void insert(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
        size++;
    }

    // Insert at a specified position
    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            Node newHead = new Node(data);
            newHead.next = head;
            head = newHead;
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(data);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // Delete the first occurrence of a value
    public boolean delete(int data) {
        if (head == null) {
            return false;
        }
        if (head.data == data) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Delete at a specified position
    public boolean deleteAtPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
        return true;
    }

    // Find the center node of the list
    public Node center() {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

//Sort the list in ascending order
public void sort() {
 if (head == null || head.next == null) {
     return;
 }
 Node current = head;
 while (current != null) {
     Node min = current;
     Node innerCurrent = current.next;
     while (innerCurrent != null) {
         if (innerCurrent.data < min.data) {
             min = innerCurrent;
         }
         innerCurrent = innerCurrent.next;
     }
     int temp = current.data;
     current.data = min.data;
     min.data = temp;
     current = current.next;
 }
}

//Reverse the order of the list
public void reverse() {
 if (head == null || head.next == null) {
     return;
 }
 Node previous = null;
 Node current = head;
 while (current != null) {
     Node next = current.next;
     current.next = previous;
     previous = current;
     current = next;
 }
 head = previous;
}

//Return the size of the list
public int size() {
 return size;
}
//Print the contents of the list
public void print() {
 Node current = head;
 while (current != null) {
     System.out.print(current.data + " ");
     current = current.next;
 }
 System.out.println();
}

}
