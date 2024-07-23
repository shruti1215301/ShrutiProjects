package Stack;

public class myStack {
    static final int MAX = 1000;
    int top;
    int[] arr;

    public myStack() {
        top = -1;
        arr = new int[MAX];
    }

    private boolean isEmpty() {
        return (top < 0);
    }

    // push implementation
    public void push(int data) {
        if (top >= MAX - 1) {
            System.out.println("Stack overFlow !!");
        } else {
            arr[++top] = data;
        }
    }

    // pop implementation
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack UnderFlow !!");
        } else {
            int value = arr[top--];
            System.out.println(value);
        }
    }

    // peek implementation
    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!!");
        } else {
            System.out.printf("Peek Element is: %d\n", arr[top]);
        }
    }

    // traversing stack
    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty ");
        } else {
            System.out.println("Items are: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    // size implementation
    public void size() {
        if (isEmpty()) {
            System.out.println("Stack is empty !! ");
        } else {
            System.out.println("Size is: " + (top + 1));
        }
    }

    // contains implementation
    public void contains(int data) {
        int idx = -1;
        if (isEmpty()) {
            System.out.println("Stack is empty !! ");
        } else {
            for (int i = top; i >= 0; i--) {
                if (arr[i] == data) {
                    idx = i;
                    break;
                }
            }
        }
        if (idx >= 0) {
            System.out.println("Yes, found at position: " + (top - idx + 1));
        } else {
            System.out.println("Not found");
        }
    }

    // Sort
    public void sorting() {
        for (int i = 0; i < top; i++) {
            for (int j = i + 1; j <= top; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Sorted items:");
        print();
    }

    public void center() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("The center element of stack is: " + arr[top / 2]);
        }
    }

    public void iterate() {
        print();
    }

    // reverse implementation
    public void reverse() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Reverse Item: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

