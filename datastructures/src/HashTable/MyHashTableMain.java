package HashTable;
import java.util.*;

import java.util.Scanner;

public class MyHashTableMain {

    public static void main(String[] args) {
        MyHashTable my_table = new MyHashTable();
        System.out.println("-----Hash Table Operations-----");
        System.out.println("1. Insert ");
        System.out.println("2. Delete ");
        System.out.println("3. Contains");
        System.out.println("4. Iterate");
        System.out.println("5. Size");
        System.out.println("6. Print ");
        System.out.println("7. Get value by key");
        System.out.println("0. Exit ");
        Scanner scanner = new Scanner(System.in);
        //here till the condition is true while loop will run
        while (true) {
            System.out.println("\nChoose option :");
            int optionNumber = scanner.nextInt();
            if (optionNumber == 0) {
                break;
            }
            // switch case used to choose which operation will be performed
            switch (optionNumber) {
                case 1:
                    System.out.println("The the number of key and value to be inserted :");
                    int insert = scanner.nextInt();
                    for (int i = 0; i < insert; i++) {
                        System.out.println("Enter key :");
                        int key = scanner.nextInt();
                        System.out.println("Enter value :");
                        String val = scanner.next();
                        my_table.insert(key, val);
                    }
                    break;

                case 2:
                    System.out.println("Enter key :");
                    int key2 = scanner.nextInt();
                    my_table.delete(key2);
                    break;

                case 3:
                    System.out.println("Enter key :");
                    int key3 = scanner.nextInt();
                    System.out.println("Enter value :");
                    String val1 = scanner.next();
                    my_table.contains(key3, val1);
                    break;

                case 4:
                    my_table.iterate();
                    break;

                case 5:
                    int ans1 = my_table.Size1();
                    System.out.println("size of this hashtable is :" + ans1);
                    break;

                case 6:
                    my_table.print();
                    break;

                case 7:
                    System.out.println("Enter Key :");
                    int key4 = scanner.nextInt();
                    String ans = my_table.get(key4);

                    System.out.println("Value for this key is: " + ans);
                    break;

                case 0:
                    System.exit(0);
                    break;
            }
        }
        scanner.close();
    }
}

