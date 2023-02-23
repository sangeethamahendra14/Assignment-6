package QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

class Patient {
    private int age;

    public Patient(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

class QueueSplitter {
    public static Queue<Patient>[] splitQueue(Queue<Patient> patientQueue) {
        Queue<Patient>[] result = new Queue[2];
        result[0] = new LinkedList<Patient>(); 
        result[1] = new LinkedList<Patient>(); 

        while (!patientQueue.isEmpty()) {
            Patient patient = patientQueue.poll();
            if (patient.getAge() >= 60) {
                result[0].offer(patient);
            } else {
                result[1].offer(patient);
            }
        }

        return result;
    }
}

class Tester {
    public static void main(String[] args) {
        Queue<Patient> patientQueue = new LinkedList<Patient>();
        patientQueue.offer(new Patient(70));
        patientQueue.offer(new Patient(40));
        patientQueue.offer(new Patient(50));
        patientQueue.offer(new Patient(80));
        patientQueue.offer(new Patient(30));

        Queue<Patient>[] result = QueueSplitter.splitQueue(patientQueue);

        System.out.println("Jack: Gender=male Age >= 60");
        while (!result[0].isEmpty()) {
            System.out.println(result[0].poll().getAge());
        }

        System.out.println("Tom:Gender=male Age < 60");
        while (!result[1].isEmpty()) {
            System.out.println(result[1].poll().getAge());
        }
    }
}
