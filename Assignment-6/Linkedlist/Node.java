package Assignment;

import java.util.HashSet;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void add(int value) {
        Node new_node = new Node(value);
        if (head == null) {
            head = new_node;
        } else {
            Node current_node = head;
            while (current_node.next != null) {
                current_node = current_node.next;
            }
            current_node.next = new_node;
        }
    }

    public void removeDuplicates() {
        if (head == null) {
            return;
        }
        HashSet<Integer> unique_values = new HashSet<Integer>();
        unique_values.add(head.value);
        Node current_node = head;
        while (current_node.next != null) {
            if (unique_values.contains(current_node.next.value)) {
                current_node.next = current_node.next.next;
            } else {
                unique_values.add(current_node.next.value);
                current_node = current_node.next;
            }
        }
    }

    public int[] toIntArray() {
        int[] result = new int[size()];
        Node current_node = head;
        int i = 0;
        while (current_node != null) {
            result[i] = current_node.value;
            current_node = current_node.next;
            i++;
        }
        return result;
    }

    public int size() {
        int count = 0;
        Node current_node = head;
        while (current_node != null) {
            count++;
            current_node = current_node.next;
        }
        return count;
    }
}

class Tester {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(15);
        list.add(21);
        list.add(15);
        list.add(10);
       
        System.out.println("Original list: " + arrayToString(list.toIntArray()));
        list.removeDuplicates();
        System.out.println("List after removing duplicates: " + arrayToString(list.toIntArray()));
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
