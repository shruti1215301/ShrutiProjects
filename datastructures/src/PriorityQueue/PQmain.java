package PriorityQueue;
import java.util.Scanner;

public class PQmain {

	public static void main(String[] args) {
		PQsecondary<String> myQueue = new PQsecondary<String>();
		
	    System.out.println("1.To create a Priorty Queue");
	    System.out.println("2.To Enqueue a element in a Queue");
	    System.out.println("3.To Dequeue a element from a Queue");
	    System.out.println("4.To Peek the  element from the Queue");
	    System.out.println("5.To Check if the Queue contains a particular element or not");
	    System.out.println("6.To get the size of the Queue");
	    System.out.println("7.To Reverse the Queue");
	    System.out.println("8.To Iterate the Queue");
	    System.out.println("9.To Print the Queue");
	    System.out.println("10.Center");
	    System.out.println("11.To Exit");
	    System.out.println("-----------------------------------------------------------------");

	    Scanner scanner = new Scanner(System.in);

	    while (true) {
	        System.out.println("Enter one of the choices(1-10) to perform related action:");
	        int choice = scanner.nextInt();

	        if (choice == 11) {
	            break;
	        } else {
	            int priorty;
	            String data;

	            switch (choice) {
	                case 1:
	                    int number;
	                    System.out.println("Enter the number of elements you want to enter in the Queue:");
	                    number = scanner.nextInt();
	                    for (int i = 0; i < number; i++) {
	                        System.out.println("Enter the data of " + (i + 1) + " element");
	                        data = scanner.next();
	                        System.out.println("Enter the Priorty of " + (i + 1) + " element");
	                        priorty = scanner.nextInt();
	                        myQueue.enqueue(priorty, data);
	                    }
	                    break;

	                case 2:
	                    System.out.println("Enter the data of the element you want to Enqueue: ");
	                    data = scanner.next();
	                    System.out.println("Enter the Priorty of the element: ");
	                    priorty = scanner.nextInt();
	                    myQueue.enqueue(priorty, data);
	                    break;

	                case 3:
	                    myQueue.dequeue();
	                    myQueue.traverse();
	                    break;

	                case 4:
	                    System.out.println(myQueue.peek());
	                    break;

	                case 5:
	                    System.out.println("Enter the value you want to check:");
	                    data = scanner.next();
	                    System.out.println(myQueue.contains(data));
	                    break;

	                case 6:
	                    System.out.println(myQueue.size());
	                    break;

	                case 7:
	                    myQueue.reverse();
	                    myQueue.traverse();
	                    break;

	                case 8:
	                    for (String item : myQueue) {
	                        System.out.print(item + " ");
	                    }
	                    System.out.println();
	                    break;

	                case 9:
	                    myQueue.traverse();
	                    break;

	                case 10:
	                    myQueue.center();
	                    myQueue.traverse();
	                    break;

	                default:
	                    System.out.println("Please Enter a valid choice!");
	                    break;
	            }
	        }
	    }
	    scanner.close();
	    System.out.println("Thanks!!");
	}}
