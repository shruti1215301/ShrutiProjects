package Queue;

import java.util.Scanner;

public class Queuemain {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();
        Queue queue = new Queue(capacity);

        while (true) {
            System.out.println();
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check if queue contains an item");
            System.out.println("5. Get queue size");
            System.out.println("6. Sort queue");
            System.out.println("7. Reverse queue");
            System.out.println("8. Get center of the queue");
            System.out.println("9. Print Queue");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
            case 1:
                System.out.print("Enter element to enqueue: ");
                int item = scanner.nextInt();
                queue.enqueue(item);
                break;
            case 2:
                int dequeuedItem = queue.dequeue();
                if (dequeuedItem != -1) {
                    System.out.println("Dequeued item: " + dequeuedItem);
                }
                break;
            case 3:
                int peekedItem = queue.peek();
                if (peekedItem != -1) {
                    System.out.println("Peeked item: " + peekedItem);
                }
                break;
            case 4:
                System.out.print("Enter element to check if it's in the queue: ");
                int itemToCheck = scanner.nextInt();
                if (queue.contains(itemToCheck)) {
                    System.out.println(itemToCheck + " is in the queue.");
                } else {
                    System.out.println(itemToCheck + " is not in the queue.");
                }
                break;
            case 5:
                int queueSize = queue.size();
                System.out.println("Queue size: " + queueSize);
                break;
            case 6:
                queue.sort();
                System.out.println("Queue sorted:");
                queue.traverse();
                break;
            case 7:
                queue.reverse();
                System.out.println("Queue reversed:");
                queue.traverse();
                break;
            case 8:
                int centerItem = queue.center();
                if (centerItem != -1) {
                    System.out.println("Center item: " + centerItem);
                }
                break;
            case 9:
                System.out.println("Printing queue:");
                queue.traverse();
                break;
            case 10:
                System.out.println("Exiting program.");
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
        }
        }
    }
}
