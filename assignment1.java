import java.util.Scanner;

// Node class to represent a student
class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

// Node class for linked list
class Node {
    Student data;
    Node next;

    public Node(Student data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class for stack operations
class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(Student data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println("Student added to the stack.");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot remove student.");
            return;
        }
        System.out.println("Removed student: " + top.data.name);
        top = top.next;
    }

    public void displayAllStudents() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No students to display.");
            return;
        }
        System.out.println("Students in the stack:");
        Node current = top;
        while (current != null) {
            System.out.println("Name: " + current.data.name + ", Marks: " + current.data.marks);
            current = current.next;
        }
    }

    public void displayTop3Positions() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No students to display.");
            return;
        }

        System.out.println("Top 3 positions:");
        Node current = top;
        int position = 1;

        while (current != null && position <= 3) {
            System.out.println("Position " + position + ": " + current.data.name + " (Marks: " + current.data.marks + ")");
            current = current.next;

            // Skip students with the same highest marks
            while (current != null && current.data.marks == top.data.marks) {
                System.out.println("Position " + position + ": " + current.data.name + " (Marks: " + current.data.marks + ")");
                current = current.next;
            }

            position++;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add a student to Stack");
            System.out.println("2. Remove a student from Stack");
            System.out.println("3. Display all students of Stack");
            System.out.println("4. Display the top 3 positions of students");
            System.out.println("5. Press 5 or any other key to close the program");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter student marks: ");
                    int marks = scanner.nextInt();
                    stack.push(new Student(name, marks));
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.displayAllStudents();
                    break;
                case 4:
                    stack.displayTop3Positions();
                    break;
                default:
                    System.out.println("Closing the program.");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}