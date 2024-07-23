package PriorityQueue;


	import java.util.Iterator;
	import java.util.NoSuchElementException;

	public class PQsecondary<T> implements Iterable<T> {
	    private class Node {
	        public int priority;
	        public T data;
	        public Node next;

	        public Node(int priority, T data) {
	            this.priority = priority;
	            this.data = data;
	        }
	    }

	    private Node head;
	    private int size;

	    public PQsecondary() {
	        head = null;
	        size = 0;
	    }

	    public void enqueue(int priority, T data) {
	        Node newNode = new Node(priority, data);
	        if (head == null || priority < head.priority) {
	            newNode.next = head;
	            head = newNode;
	        } else {
	            Node current = head;
	            while (current.next != null && priority >= current.next.priority) {
	                current = current.next;
	            }
	            newNode.next = current.next;
	            current.next = newNode;
	        }
	        size++;
	    }

	    public T dequeue() {
	        if (head == null) {
	            throw new NoSuchElementException("Priority queue is empty");
	        }
	        T data = head.data;
	        head = head.next;
	        size--;
	        return data;
	    }

	    public T peek() {
	        if (head == null) {
	            throw new NoSuchElementException("Priority queue is empty");
	        }
	        return head.data;
	    }

	    public boolean contains(T data) {
	        Node current = head;
	        while (current != null) {
	            if (current.data.equals(data)) {
	                return true;
	            }
	            current = current.next;
	        }
	        return false;
	    }

	    public int size() {
	        return size;
	    }

	    public void center() {
	        if (head == null) {
	            throw new NoSuchElementException("Priority queue is empty");
	        }
	        Node slow = head;
	        Node fast = head;
	        while (fast.next != null && fast.next.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        System.out.println("Center element: " + slow.data);
	    }

	    public void reverse() {
	        Node prev = null;
	        Node current = head;
	        Node next = null;
	        while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        head = prev;
	    }

	    public void traverse() {
	        Node current = head;
	        while (current != null) {
	            System.out.print("[" + current.priority + ":" + current.data + "] ");
	            current = current.next;
	        }
	        System.out.println();
	    }

	    public Iterator<T> iterator() {
	        return new PriorityQueueIterator();
	    }

	    private class PriorityQueueIterator implements Iterator<T> {
	        private Node current = head;

	        public boolean hasNext() {
	            return current != null;
	        }

	        public T next() {
	            if (!hasNext()) {
	                throw new NoSuchElementException();
	            }
	            T data = current.data;
	            current = current.next;
	            return data;
	        }

	        public void remove() {
	            throw new UnsupportedOperationException();
	        }
	    }
	}


