package Queue;

import java.util.Arrays;


public class Queue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int size;
    
    Queue(int[] elements) {
        queueArray = elements;
        front = 0;
        rear = elements.length - 1;
        size = elements.length;
    }

    public Queue(int capacity) {
        queueArray = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        queueArray[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queueArray[front];
        front++;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queueArray[front];
    }

    public boolean contains(int item) {
        for (int i = front; i <= rear; i++) {
            if (queueArray[i] == item) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public int center() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int centerIndex = front + (size / 2);
        return queueArray[centerIndex];
    }

    public void sort() {
        Arrays.sort(queueArray, front, rear + 1);
    }

    public void reverse() {
        int left = front;
        int right = rear;
        while (left < right) {
            int temp = queueArray[left];
            queueArray[left] = queueArray[right];
            queueArray[right] = temp;
            left++;
            right--;
        }
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(queueArray[i] + " ");
        }
        System.out.println();
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return rear == queueArray.length - 1;
    }

    
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   