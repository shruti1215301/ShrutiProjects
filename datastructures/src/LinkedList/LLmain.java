package LinkedList;
import java.util.Scanner;

import LinkedList.LL.Node;

public class LLmain {
	    public static void main(String[] args) {
	        LL list = new LL();
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	        do {
	            System.out.println("\nChoose an operation:");
	            System.out.println("1. Insert");
	            System.out.println("2. Insert at position");
	            System.out.println("3. Delete");
	            System.out.println("4. Delete at position");
	            System.out.println("5. Center");
	            System.out.println("6. Sort");
	            System.out.println("7. Reverse");
	            System.out.println("8. Size");
	            System.out.println("9. Print");
	            System.out.println("0. Exit");

	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter data: ");
	                    int data = scanner.nextInt();
	                    list.insert(data);
	                    break;

	                case 2:
	                    System.out.print("Enter data: ");
	                    int data1 = scanner.nextInt();
	                    System.out.print("Enter position: ");
	                    int position = scanner.nextInt();
	                    list.insertAtPosition(data1, position);
	                    break;

	                case 3:
	                    System.out.print("Enter data to delete: ");
	                    int data2 = scanner.nextInt();
	                    if (list.delete(data2)) {
	                        System.out.println(data2 + " was deleted.");
	                    } else {
	                        System.out.println(data2 + " was not found in the list.");
	                    }
	                    break;

	                case 4:
	                    System.out.print("Enter position to delete: ");
	                    int position1 = scanner.nextInt();
	                    if (list.deleteAtPosition(position1)) {
	                        System.out.println("Node at position " + position1 + " was deleted.");
	                    } else {
	                        System.out.println("Node at position " + position1 + " was not found in the list.");
	                    }
	                    break;

	                case 5:
	                    Node center = list.center();
	                    if (center != null) {
	                        System.out.println("Center node: " + center.data);
	                    } else {
	                        System.out.println("List is empty.");
	                    }
	                    break;

	                case 6:
	                    list.sort();
	                    System.out.println("List sorted.");
	                    break;

	                case 7:
	                    list.reverse();
	                    System.out.println("List reversed.");
	                    break;

	                case 8:
	                    System.out.println("List size: " + list.size());
	                    break;

	                case 9:
	                    System.out.print("List contents: ");
	                    list.print();
	                    break;

	                case 0:
	                    System.out.println("Exiting program.");
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        } while (choice != 0);
	        scanner.close();
	    }
	}
