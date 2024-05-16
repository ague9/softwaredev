package hw2.a1;

import java.util.ArrayList;
import java.util.List;

public class Seminar<T extends IStudent>{
    private String name;
    private String id;

    //TODO: List of participants
    private List<T> participants;

    public Seminar(String name, String id) {
        this.name = name;
        this.id = id;
        //TODO: Initialize list of participants
        this.participants = new ArrayList<>();
    }

    public void addParticipant(T participant) {
        //TODO: Add to list of participants
        participants.add(participant);
    }

    public List<T> getParticipants() {
        return participants;
    }

    public List<T> getParticipantsFromStudyProgram(String subject) {
        List<T> matchingParticipants = new ArrayList<>();
        for (T participant : participants) {
            if (participant.getSubject().equals(subject)) {
                matchingParticipants.add(participant);
            }
        }
        return matchingParticipants;
    }




    public static void main(String[] args) {
        Seminar<PhD> phdStudents = new Seminar<PhD>("Doktorandenseminar", "");
        phdStudents.addParticipant(new PhD("Adrian", "Software Engineering"));
        phdStudents.addParticipant(new PhD("Alice", "Software Engineering"));
        phdStudents.addParticipant(new PhD("Bob", "Algorithmics"));
        phdStudents.addParticipant(new PhD("Charly", "Visual Analytics"));

        Seminar<Student> bachelorStudents = new Seminar<Student>("Seminar Software Engineering", "SSE");
        bachelorStudents.addParticipant(new Student("Zedrick", "Wirtschaftsinformatik"));
        bachelorStudents.addParticipant(new Student("Yvonne", "Wirtschaftsinformatik"));
        bachelorStudents.addParticipant(new Student("Wladislav", "Mathematik"));
        bachelorStudents.addParticipant(new Student("Xenia", "Informatik"));
        bachelorStudents.addParticipant(new Student("Udo", "Informatik"));

        System.out.println(phdStudents.getParticipantsFromStudyProgram("Software Engineering"));
        System.out.println();
        System.out.println(phdStudents.getParticipantsFromStudyProgram("Algorithmics"));
        System.out.println();
        System.out.println(phdStudents.getParticipantsFromStudyProgram("Visual Analytics"));
        System.out.println();

        System.out.println(bachelorStudents.getParticipantsFromStudyProgram("Wirtschaftsinformatik"));
        System.out.println();
        System.out.println(bachelorStudents.getParticipantsFromStudyProgram("Mathematik"));
        System.out.println();
        System.out.println(bachelorStudents.getParticipantsFromStudyProgram("Informatik"));
        System.out.println();
    }
}
