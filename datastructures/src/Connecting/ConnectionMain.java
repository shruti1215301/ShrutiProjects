package Connecting;

import java.util.Scanner;


import LinkedList.*;
import HashTable.*;
import PriorityQueue.*;
import Queue.*;
import Stack.*;

public class ConnectionMain {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        String choice;
        
        do {
            System.out.println("Choose a data structure to use:");
            System.out.println("1. Linked List");
            System.out.println("2. Queue");
            System.out.println("3. Stack");
            System.out.println("4. Priority Queue");
            System.out.println("5. Hash Table");
            System.out.println("0. Exit");
            
            choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    LL linkedList = new LL();
                    LLmain.main(new String[0]);
                    break;
                case "2":
                    Queue queue = new Queue(4);
                    Queuemain.main(new String[0]);// Perform operations on queue
                    break;
                case "3":
                	mystackmain.main(new String[0]);
                    break;
                case "4":
                	PQmain.main(new String[0]);
                    break;
                case "0":
                    System.out.println("Exiting...");
                    break;
                
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            
            System.out.println();
        } while (!choice.equals("0"));
        
        scanner.close();
    }
}
