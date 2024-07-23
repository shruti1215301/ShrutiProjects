package HashTable;
import java.util.*;;


	public class MyHashTable {
	    private int key;
	    private String data;
	    private Node next;

	    public MyHashTable(int key, String data) {
	        this.key = key;
	        this.data = data;
	        next = null;
	    }

	    public int getKey() {
	        return key;
	    }

	    public String getData() {
	        return data;
	    }

	    public void setNextNode(Node obj) {
	        next = obj;
	    }

	    public Node getNextNode() {
	        return next;
	    }

	    static class Node {
	        private int key;
	        private String data;
	        private Node next;

	        public Node(int key, String data) {
	            this.key = key;
	            this.data = data;
	            next = null;
	        }

	        public int getKey() {
	            return key;
	        }

	        public String getData() {
	            return data;
	        }

	        public void setNextNode(Node obj) {
	            next = obj;
	        }

	        public Node getNextNode() {
	            return next;
	        }
	    }

	    Node[] table;
	    private final int size = 10;
	    private int size_var = 0;

	    public MyHashTable() {
	        table = new Node[size];
	        for (int i = 0; i < size; i++) {
	            table[i] = null;
	        }
	    }

	    public void insert(int key, String data) {
	        Node nObj = new Node(key, data);
	        int hash = key % size;
	        while (table[hash] != null && table[hash].getKey() % size != key % size) {
	            hash = (hash + 1) % size;
	        }
	        if (table[hash] != null && hash == table[hash].getKey() % size) {
	            nObj.setNextNode(table[hash].getNextNode());
	            table[hash].setNextNode(nObj);
	            return;
	        } else {
	            table[hash] = nObj;
	            System.out.println("Entry added successfully");
	            size_var++;
	            return;
	        }
	    }

	    public String get(int key) {
	        int hash = key % size;
	        while (table[hash] != null && table[hash].getKey() % size != key % size) {
	            hash = (hash + 1) % size;
	        }
	        Node current = table[hash];
	        while (current != null && current.getKey() != key) {
	            current = current.getNextNode();
	        }
	        if (current != null && current.getKey() == key) {
	            return current.getData();
	        } else {
	            return "Nothing found!";
	        }
	    }

	    public void delete(int key) {
	        int hash = key % size;
	        while (table[hash] != null && table[hash].getKey() % size != key % size) {
	            hash = (hash + 1) % size;
	        }
	        Node current = table[hash];
	        Node prev = null;
	        while (current != null && current.getKey() != key) {
	            prev = current;
	            current = current.getNextNode();
	        }
	        if (current != null && current.getKey() == key) {
	            if (prev == null) {
	                table[hash] = current.getNextNode();
	            } else {
	                prev.setNextNode(current.getNextNode());
	            }
	            System.out.println("Entry removed successfully!");
	            size_var--;
	        } else {
	            System.out.println("Nothing found to delete!");
	            return;
	        }
	    }

	    

public void print() {
if (size_var == 0) {
    System.out.println("Hashtable is empty. Insert elements first!!");
}
Node current = null;
for (int i = 0; i < size; i++) {
    current = table[i];
    while (current != null) {
        System.out.print(current.getKey() + ":" + current.getData() + " , ");
        current = current.getNextNode();
    }
}
}

public void contains(int key, String val) {
    Node current;
    for (int i = 0; i < size; i++) {
        current = table[i];
        while (current != null) {
            if (current.getData().equals(val) && current.getKey() == key) {
                System.out.println("Yes, hashtable contains this key-value pair");
                return;
            }
            current = current.getNextNode();
        }
    }
    System.out.println("No, hashtable does not contain this key-value pair");
}
public void iterate() {
    for (int i = 0; i < size; i++) {
        Node current = table[i];
        while (current != null) {
            System.out.println("Key: " + current.getKey() + ", Value: " + current.getData());
            current = current.getNextNode();
        }
    }
}

public int Size1() {
    return size_var;
}
}
