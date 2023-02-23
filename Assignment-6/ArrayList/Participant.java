package ArrayList;

import java.util.ArrayList;
import java.util.List;

class Participant {
    private String name;
    private double averageScore;

    public Participant(String name, double averageScore) {
        this.name = name;
        this.averageScore = averageScore;
    }

    public String getName() {
        return name;
    }

    public double getAverageScore() {
        return averageScore;
    }
}

 class AmazingTalent {
    public static ArrayList<Participant> generateListOfFinalists(Participant[] finalists) {
        ArrayList<Participant> list = new ArrayList<>();
        for (Participant p : finalists) {
            list.add(p);
        }
        return list;
    }

    public static ArrayList<Participant> getFinalistsByTalent(List<Participant> finalists, String talent) {
        ArrayList<Participant> list = new ArrayList<>();
        for (Participant p : finalists) {
            if (talent.equals("All") || talent.equals("all") || p.getName().contains(talent)) {
                list.add(p);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Participant[] finalists = { new Participant("John", 85.5), new Participant("Mary", 91.2),
                new Participant("Tom", 78.6), new Participant("Emma", 88.9) };
        ArrayList<Participant> list = generateListOfFinalists(finalists);

        System.out.println("List of all finalists:");
        for (Participant p : list) {
            System.out.println(p.getName() + " - " + p.getAverageScore());
        }

        System.out.println("\nList of finalists for talent - Singing:");
        ArrayList<Participant> singingList = getFinalistsByTalent(list, "Singing");
        for (Participant p : singingList) {
            System.out.println(p.getName() + " - " + p.getAverageScore());
        }
    }
}
