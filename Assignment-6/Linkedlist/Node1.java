package LinkedList;

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

    public LinkedList findCommonElements(LinkedList other) {
        LinkedList result = new LinkedList();
        HashSet<Integer> values = new HashSet<Integer>();
        Node current_node = head;
        while (current_node != null) {
            values.add(current_node.value);
            current_node = current_node.next;
        }
        current_node = other.head;
        while (current_node != null) {
            if (values.contains(current_node.value)) {
                result.add(current_node.value);
            }
            current_node = current_node.next;
        }
        return result;
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
        LinkedList list1 = new LinkedList();
        list1.add(10);
        list1.add(12);
        list1.add(21);
        list1.add(1);
        list1.add(53);
        LinkedList list2 = new LinkedList();
        list2.add(11);
        list2.add(21);
        list2.add(25);
        list2.add(53);
        list2.add(47);
        LinkedList common = list1.findCommonElements(list2);
        System.out.println("List 1: " + arrayToString(list1.toIntArray()));
        System.out.println("List 2: " + arrayToString(list2.toIntArray()));
        System.out.println("Common elements: " + arrayToString(common.toIntArray()));
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
