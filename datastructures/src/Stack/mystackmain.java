package Stack;

import java.util.*;

public class mystackmain {
	 public static void main(String[] args) {
	        Stack<Integer> st = new Stack<Integer>();
	        Scanner sc = new Scanner(System.in);

	        System.out.println("-----Stack Operations-----");
	        System.out.println("1. Push ");
	        System.out.println("2. Pop");
	        System.out.println("3. Peek");
	        System.out.println("4. Contains");
	        System.out.println("5. Center");
	        System.out.println("6. Reverse ");
	        System.out.println("7. Print/Traverse ");
	        System.out.println("8. Size ");
	        System.out.println("9. Iterate ");
	        System.out.println("10.Sorting ");
	        System.out.println("0. Exit ");

	        // here till the condition is true while loop will run
	        while (true) {
	            System.out.println("\nChoose option :");
	            int optionNumber = sc.nextInt();
	            if (optionNumber == 0)
	                break;

	            // switch case used to choose which operation will be performed
	            switch (optionNumber) {
	                case 1:
	                    System.out.println("Enter the number of value you want to insert:");
	                    int insert = sc.nextInt();
	                    for (int i = 0; i < insert; i++) {
	                        System.out.println("Enter value :");
	                        int data = sc.nextInt();
	                        st.push(data);
	                        System.out.println("pushed succesfully");
	                    }
	                    break;
	                case 2:
	                    st.pop();
	                    System.out.println("popped succesfully");
	                    break;
	                case 3:
	                    System.out.println(st.peek());
	                    break;
	                case 4:
	                    System.out.println("Enter data to be searched :");
	                    int data1 = sc.nextInt();
	                    System.out.println(st.contains(data1));
	                    break;
	                case 5:
	                    int center = st.size() / 2;
	                    System.out.println("The center element is: " + st.get(center));
	                    break;
	                case 6:
	                    Stack<Integer> tempStack = new Stack<Integer>();
	                    while (!st.isEmpty())
	                        tempStack.push(st.pop());
	                    st = tempStack;
	                    System.out.println("Stack is reversed.");
	                    break;
	                case 7:
	                    for (int element : st)
	                        System.out.print(element + " ");
	                    System.out.println();
	                    break;
	                case 8:
	                    System.out.println("Size of the stack is: " + st.size());
	                    break;
	                case 9:
	                    System.out.println("Iterating the stack...");
	                    ListIterator<Integer> iterator = st.listIterator(st.size());
	                    while (iterator.hasPrevious()) {
	                        int element = iterator.previous();
	                        System.out.print(element + " ");
	                    }
	                    System.out.println();
	                    break;
	                case 10:
	                    Stack<Integer> sortedStack = new Stack<Integer>();
	                    while (!st.isEmpty()) {
	                        int element = st.pop();
	                        while (!sortedStack.isEmpty() && sortedStack.peek() > element)
	                            st.push(sortedStack.pop());
	                        sortedStack.push(element);
	                    }
	                    st = sortedStack;
	                    System.out.println("Stack is sorted.");
	                    break;
	                default:
	                    System.out.println("Invalid option. Please choose a valid option.");
	            }
	        }
	        sc.close();
	    }
	}



